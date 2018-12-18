xyx.controller('MainController', ['$cookies', "$window", 'ngTableParams', '$scope', '$uibModal', '$filter', '$rootScope', '$timeout', 'noty', '$location', 'xyxUtil', 'AuthService','$route',
    function ($cookies, $window, ngTableParams, $scope, $uibModal, $filter, $rootScope, $timeout, noty, $location, fasConfig, AuthService,$route) {

        $scope.userName = "";


        $rootScope.data = [];
        $rootScope.columns = [];
        $rootScope.dataz = [];
        $rootScope.filter_dict = {};
        $rootScope.sortByColumn = "";
        $rootScope.reverse = false;

        $rootScope.changeSearchCondition = function (newCondition) {
            $rootScope.searchBy = newCondition;
        };

        $rootScope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: fasConfig.DEFAULT_PAGE_SIZE,         // count per page
            filter: $rootScope.filter_dict

        }, {
            getData: function ($defer, params) {

                $rootScope.dataz = [];
                angular.copy($rootScope.data, $rootScope.dataz);
                $rootScope.dataz = $filter('filter')($rootScope.dataz, $rootScope.filter_dict);
                $rootScope.dataz = $filter('orderBy')($rootScope.dataz, $rootScope.sortByColumn, $rootScope.reverse);
                params.total($rootScope.dataz.length);
                $rootScope.totalRows = $rootScope.dataz.length;
                $defer.resolve($rootScope.dataz.slice((params.page() - 1) * params.count(), params.page() * params.count()));


            }
        });

        $rootScope.sortTable = function (sortColumn) {
            $rootScope.sortByColumn = sortColumn;
            $rootScope.reverse = !$rootScope.reverse;
            $rootScope.tableParams.reload();
        };

        $rootScope.filterPress = function () {
            $rootScope.tableParams.reload();

        };

        $rootScope.childInfo = {};

        $rootScope.cleanRootValues = function () {
            $rootScope.data = [];
            $rootScope.columns = [];
            $rootScope.dataz = [];
            $rootScope.filter_dict = {};
            $rootScope.sortByColumn = "";
            $rootScope.reverse = false;
            $rootScope.showSum = false;
            $rootScope.crAmount = 0;
            $rootScope.drAccount = 0;
            $rootScope.balance = 0;
        };

        $rootScope.showLeftNav = function () {
            $rootScope.showLN = !$rootScope.showLN;
        };

    }]);
