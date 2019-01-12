'use strict';
//restful service

xyxPay.factory('PayService', ['$resource', 'xyxUtil', function ($resource, config) {
    return $resource('', {}, {
        'pay': {
            url: config.WEBROOTURL + 'pay',
            method: 'POST',
            headers: {'Content-Type': "application/json;charset=utf-8"},
            isArray: false,
            cache: false
        }

    });
}]);
