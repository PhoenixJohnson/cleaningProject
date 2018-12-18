'use strict';
//restful service

xyxPay.factory('UserService', ['$resource', 'xyxUtil', function ($resource, config) {
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
