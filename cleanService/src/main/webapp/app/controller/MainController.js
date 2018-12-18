xyxPay.controller('MainController', ["$window", '$scope', '$sce',
    function ($window, $scope, $sce) {

        $scope.deviceId = "18364GYY88NB001";
        $scope.buyDesc = $sce.trustAsHtml("<div style='text-align: center;'>请选择洗车项目<div>");
        $scope.washOptions = {
            "simple": {
                "washMethod": "simple",
                "price": 18,
                "washDesc": "<div class='title'>冲洗方案：精简冲洗</div>" +
                    "<div>冲洗时间：5分钟</div>" +
                    "<div>冲洗介绍：xxxxx</div>"
            },
            "standard": {
                "washMethod": "standard",
                "price": 25,
                "washDesc": "<div>冲洗方案：标准冲洗</div>" +
                    "<div>冲洗时间：10分钟</div>" +
                    "<div>冲洗介绍：xxxxx</div>"
            },
            "luxury": {
                "washMethod": "luxury",
                "price": 45,
                "washDesc": "<div>冲洗方案：豪华冲洗</div>" +
                    "<div>冲洗时间：15分钟</div>" +
                    "<div>冲洗介绍：xxxxx</div>"
            }
        };
        $scope.getWashDesc = function () {
            $scope.buyDesc = $sce.trustAsHtml($scope.selectedWashOpt.washDesc);
        };

        $scope.selectedWashOpt = {};

        $scope.changeMethod = function (method) {
            $scope.selectedWashOpt = $scope.washOptions[method];
            $scope.getWashDesc();
        }

    }]);
