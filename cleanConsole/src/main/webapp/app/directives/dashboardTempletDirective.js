xyx.directive('strategiesBoard', [function () {
    return {
        restrict: 'E',
        scope: {
            accountStrategy: "=",
            transactionStrategy: "=",
            batchStrategy: "=",
            journalStrategy: "="
        },
        templateUrl: 'app/fas/partials/components/StrategiesBoard.html',
        controller: ["$scope", function ($scope) {
            //TODO data conversion here
        }]
    };
}]);

xyx.directive('searchTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/KeyWordSearchTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);


xyx.directive('payoutTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/PayoutTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('apjTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/APJTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('chainTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/ChainTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('moneyTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/MoneyTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('moneyRawTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/MoneyRawTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('eventSearchTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/EventSearchTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);

xyx.directive('tableSearchTemplate', [function () {
    return {
        restrict: 'E',
        templateUrl: 'app/fas/partials/components/TableSearchTemplate.html',
        scope: {},
        controller: "@",
        name:"controllerName"
    };
}]);
