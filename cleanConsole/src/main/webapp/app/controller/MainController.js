xyx.controller('MainController', ['$cookies', "$window", 'ngTableParams', '$scope', '$uibModal', '$filter', '$rootScope', '$timeout', 'noty', '$location', 'xyxUtil', 'AuthService', '$route', 'PaymentService','$interval',
    function ($cookies, $window, ngTableParams, $scope, $uibModal, $filter, $rootScope, $timeout, noty, $location, fasConfig, AuthService, $route, PaymentService, $interval) {

        $scope.userName = "";


        $rootScope.data = [];
        $rootScope.columns = [];
        $rootScope.dataz = [];
        $rootScope.filter_dict = {};
        $rootScope.sortByColumn = "";
        $rootScope.reverse = false;
        $scope.totalAmount = 0;
        $interval(function () {
            $scope.now = new Date();
        }, 1000);

        $timeout(function(){
            PaymentService.getPaymentsRT({},function(response) {

                /** @namespace response.responseObjList */
                var res = response.responseObjList;
                angular.forEach(res,function(rec) {
                    $scope.totalAmount += rec.payAmount;
                });
                $rootScope.columns = [
                    {
                        field:"storeId",
                        desc:"店铺Id"
                    },
                    {
                        field:"userId",
                        desc:"用户Id"
                    },
                    {
                        field:"carId",
                        desc:"车辆Id"
                    },
                    {
                        field:"paymentMethod",
                        desc:"支付方式"
                    },
                    {
                        field:"userPaymentAccount",
                        desc:"支付账号"
                    },
                    {
                        field:"storePaymentAccount",
                        desc:"店铺收款账户"
                    },
                    {
                        field:"payAmount",
                        desc:"支付金额"
                    },
                    {
                        field:"incentiveAmount",
                        desc:"优惠"
                    },
                    {
                        field:"creationDate",
                        desc:"支付时间"
                    }
                ];
                $rootScope.data = res;
                $rootScope.tableParams.reload();

            }, function(error) {

            });
        },1000);

        $interval(function(){
            PaymentService.getPaymentsRT({},function(response) {

                /** @namespace response.responseObjList */
                var res = response.responseObjList;
                $rootScope.columns = [
                    {
                        field:"storeId",
                        desc:"店铺Id"
                    },
                    {
                        field:"userId",
                        desc:"用户Id"
                    },
                    {
                        field:"carId",
                        desc:"车辆Id"
                    },
                    {
                        field:"paymentMethod",
                        desc:"支付方式"
                    },
                    {
                        field:"userPaymentAccount",
                        desc:"支付账号"
                    },
                    {
                        field:"storePaymentAccount",
                        desc:"店铺收款账户"
                    },
                    {
                        field:"payAmount",
                        desc:"支付金额"
                    },
                    {
                        field:"incentiveAmount",
                        desc:"优惠"
                    },
                    {
                        field:"creationDate",
                        desc:"支付时间"
                    }
                ];
                $rootScope.data = res;
                $rootScope.tableParams.reload();

            }, function(error) {

            });
        },20000);



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
