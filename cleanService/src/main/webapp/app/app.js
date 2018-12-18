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
var xyxPay = angular.module('xyxPay',
    [
        'ngCookies',
        'ngResource',
        'ui.bootstrap',
        'ngRoute'
    ]);


// bootstrap angular
xyxPay.config(['$routeProvider', '$locationProvider', '$httpProvider',
    function ($routeProvider, $locationProvider, $httpProvider) {



    }]);

// this is run after angular is instantiated and bootstrapped
xyxPay.run(function ($rootScope, $animate, $location) {

    // *****
    // Initialize authentication
    // *****


});

