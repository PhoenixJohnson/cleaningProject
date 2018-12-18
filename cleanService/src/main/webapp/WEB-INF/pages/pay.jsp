<%@ page contentType="text/html; charset=utf-8"%>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>喜伊喜支付页面</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="css/awesome-font.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark" ng-app="xyxPay" ng-cloak>

    <div class="container" ng-controller="MainController">

      <div class="card mx-auto mt-5" style="width: 18rem;">
        <div class="card-body">
          <div class="card-title font-weight-bold badge-dark">{{'设备号：' + deviceId}}</div>
          <p class="card-text" ng-bind-html="buyDesc"></p>
        </div>
      </div>

      <div class="card card-login mx-auto mt-5">
        <div class="card-body">
          <form>
            <ul class="list-group">
              <li class="list-group-item" ng-class="selectedWashOpt.washMethod=='simple'?'active':''" ng-click="changeMethod('simple')">简易冲洗
                <span class="badge badge-pill badge-success">{{washOptions["simple"].price}}元</span></li>
              <li class="list-group-item" ng-class="selectedWashOpt.washMethod=='standard'?'active':''" ng-click="changeMethod('standard')">精细冲洗
                <span class="badge badge-pill badge-success">{{washOptions["standard"].price}}元</span></li>
              <li class="list-group-item" ng-class="selectedWashOpt.washMethod=='luxury'?'active':''" ng-click="changeMethod('luxury')">豪华冲洗
                <span class="badge badge-pill badge-success">{{washOptions["luxury"].price}}元</span></li>
            </ul>
            <a class="btn btn-primary btn-block mt-4" href="index">支付
              <span class="badge badge-pill badge-primary" ng-if="selectedWashOpt.price">{{selectedWashOpt.price}}元</span></a>
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>


    <script src="vendor/angular/angular.js"></script>
    <script src="vendor/angular/angular-cookies.js"></script>
    <script src="vendor/angular/spin.min.js"></script>
    <script src="vendor/angular/jquery.noty.js"></script>
    <script src="vendor/angular/angular-loading.js"></script>
    <script src="vendor/angular/angular-route.js"></script>
    <script src="vendor/angular/angular-resource.js"></script>
    <script src="vendor/angular/angular-drag-and-drop-lists.js"></script>
    <script src="vendor/angular/angular-noty.dist.js"></script>
    <script src="vendor/angular/angular-animate.js"></script>
    <script src="vendor/angular/angular-sanitize.js"></script>
    <script src="vendor/angular/angular-sequence-diagram.js"></script>
    <script src="vendor/angular/ng-prettyjson.js"></script>
    <script src="vendor/angular/ng-table.js"></script>
    <script src="vendor/angular/angular-chart.js"></script>
    <script src="vendor/angular/ui-bootstrap-tpls-3.0.4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>


    <script src="app.js?<%=System.currentTimeMillis()%>"></script>
    <script src="config.js?<%=System.currentTimeMillis()%>"></script>
    <script src="services.js?<%=System.currentTimeMillis()%>"></script>

    <script src="directives/effectiveDirective.js?<%=System.currentTimeMillis()%>"></script>

    <script src="controller/MainController.js?<%=System.currentTimeMillis()%>"></script>



  </body>

</html>
