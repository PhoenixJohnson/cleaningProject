/*
 Definition of:
 # Global Variables
 # Prototype class overwrite
 */
GOLABLE_PORT = window.location.port;
//Array remove and insert method
Array.prototype.remove = function (index) {
    if (index >= 0 && index < this.length) {
        var part1 = this.slice(0, index);
        var part2 = this.slice(index);
        part1.pop();
        return (part1.concat(part2));
    }
    return this;
};
Array.prototype.insert = function (index, value) {
    if (index < 0) {
        index = this.length;
    }
    var part1 = this.slice(0, index);
    var part2 = this.slice(index);
    part1.push(value);
    return (part1.concat(part2));
};

// declare top-level module which depends on filters,and services
var xyx = angular.module('xyx',
    [
        'ngCookies',
        'ngResource',
        'ui.bootstrap',
        'ngRoute',
        'ngSanitize',
        'ngPrettyJson',
        'darthwade.loading',
        'ngTable',
        'notyModule',
        'ngAnimate'
    ]);


// bootstrap angular
xyx.config(['$routeProvider', '$locationProvider', '$httpProvider',
    function ($routeProvider, $locationProvider, $httpProvider) {

        $httpProvider.interceptors.push(['$location', '$loading', '$q', 'noty', function ($location, $loading, $q, noty) {
            return {
                'request': function (request) {
                    $loading.start("loadingMask");
                    return request;
                },
                'response': function (response) {
                    $loading.finish("loadingMask");
                    if (response.data && response.data.redirect) {
                        localStorage.removeItem('authCode');
                        localStorage.removeItem('roleList');
                        localStorage.removeItem('authorized');
                        localStorage.removeItem('currentUser');
                        location.reload();
                    }
                    if (response.data && response.data.success == true && response.data.shortMessage) {
                        noty.show("Response succeed! " + response.data.shortMessage, "success");
                    } else if (response.data && response.data.success == false) {
                        noty.show("Response failed! " + response.data.shortMessage, "error");
                    }
                    return response;
                },
                'responseError': function (response) {
                    if (response.status === 401) {
                        //TODO auto failed do stuff
                    }
                    $loading.finish("loadingMask");
                    return $q.reject(response);
                }
            };
        }]);

        $routeProvider
            .when("/", {
                templateUrl: "sections/main/DashBoard.html"
            })
            .otherwise({
                redirectTo: "/"
            });


    }]);

// this is run after angular is instantiated and bootstrapped
xyx.run(function ($rootScope, $animate, AuthService, $location) {

    // *****
    // Initialize authentication
    // *****


});

