'use strict';
//restful service

xyx.factory('UserService', ['$resource', 'xyxUtil', function ($resource, config) {
    return $resource('', {}, {
        'createConsoleUser': {
            url: config.WEBROOTURL + 'console/user',
            method: 'POST',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        },
        'findAllConsoleUser': {
            url: config.WEBROOTURL + 'console/user/findAllConsoleUser',
            method: 'GET',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        },
        'updateUser': {
            url: config.WEBROOTURL + 'console/user',
            method: 'PUT',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        },
        'findUserById': {
            url: config.WEBROOTURL + 'console/user/findUserById',
            method: 'GET',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        },
        'findUserByRole': {
            url: config.WEBROOTURL + 'console/user/role',
            method: 'GET',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        }

    });
}]);

xyx.factory('LoginService', ['$resource', 'xyxUtil', function ($resource, config) {
    return $resource('', {}, {
        'login': {
            url: config.WEBROOTURL + 'login',
            method: 'POST',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        },
        'logout': {
            url: config.WEBROOTURL + 'logout',
            method: 'GET',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        }

    });
}]);

xyx.factory('AuthService', ['$http', 'LoginService', 'noty', '$route', function ($http, Login, noty, $route, $location) {
        var currentUser = null;
        var authorized = false;
        var roleList = "";
        var authCode = "";

        return {
            login: function (loginName) {
                Login.login({userName: loginName}, function (response) {
                    if (response.success) {
                        /** @namespace response.responseObj.userRoleList */
                        roleList = response.responseObj && response.responseObj.userRoleList ? response.responseObj.userRoleList : "";
                        localStorage.setItem("currentUser", response.responseObj.userName);
                        localStorage.setItem("roleList", roleList);
                        localStorage.setItem("authorized", true);
                        localStorage.setItem("authCode", response.responseObj.token || "");
                        noty.show("Login Successfully! Welcome to FAS Console, " + response.responseObj.userName, "success");
                        $route.reload();
                    }
                }, function (error) {
                    noty.show("Login failed, Please try again", "error");
                });

            },
            isAdjustEditor: function () {
                roleList = localStorage.getItem("roleList");
                if (roleList && roleList.indexOf("ADJUST_GROUP") >= 0)
                    return true;
                else
                    return false;
            },
            isAdjustExecutor: function () {
                roleList = localStorage.getItem("roleList");
                if (roleList && roleList.indexOf("ADJUST_EXECUTE_GROUP") >= 0)
                    return true;
                else
                    return false;
            },
            isUMer: function () {
                roleList = localStorage.getItem("roleList");
                if (roleList && roleList.indexOf("UM_GROUP") >= 0)
                    return true;
                else
                    return false;
            },
            isMDer: function () {
                roleList = localStorage.getItem("roleList");
                if (roleList && roleList.indexOf("MODIFICATION_GROUP") >= 0)
                    return true;
                else
                    return false;
            },
            getRoleList: function () {
                return localStorage.getItem('roleList');
            },
            logout: function () {
                var requestObj = {
                    userName: localStorage.getItem("currentUser")
                };
                Login.logout(requestObj, function (response) {
                    if (response.success) {
                        //TODO We should first remove session storage info even logout api call failed?
                        localStorage.removeItem('authCode');
                        localStorage.removeItem('roleList');
                        localStorage.removeItem('authorized');
                        localStorage.removeItem('currentUser');
                        $location.path("/");
                    }
                }, function (error) {
                    noty.show("Logout failed, Please try again", "error");
                });

            },
            isLoggedIn: function () {
                return localStorage.getItem("authorized");
            },
            currentUser: function () {
                return localStorage.getItem("currentUser");
            },
            authorized: function () {
                return localStorage.getItem("authorized");
            }
        };
    }]
);




