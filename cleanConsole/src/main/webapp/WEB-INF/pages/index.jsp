<%@ page contentType="text/html; charset=utf-8" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>喜伊喜店铺管理</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="css/awesome-font.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top" ng-app="xyx">

<div dw-loading="loadingMask" style="height:100%;">
    <div class="wrapper" ng-controller="MainController" style="height:100%" id="mainPad">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            <a class="navbar-brand mr-1" href="index">喜伊喜</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="快速检索" aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" id="alertsDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <span class="badge badge-danger">9+</span>
                    </a>
                </li>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle"  id="userDropdown" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" >设置</a>
                        <a class="dropdown-item" >密码修改</a>
                        <a class="dropdown-item" href="forgot.jsp">忘记密码</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item"  data-toggle="modal" data-target="#logoutModal">退出</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="wrapper">
            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>总览</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="pagesDropdown" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>信息查询</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">实时记录</h6>
                        <a class="dropdown-item">实时设备运作</a>
                        <a class="dropdown-item">实时客流</a>
                        <a class="dropdown-item">实时反馈</a>
                        <h6 class="dropdown-header">历史记录</h6>
                        <a class="dropdown-item">设备历史</a>
                        <a class="dropdown-item">客户历史</a>
                        <a class="dropdown-item">历史反馈</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="charts.jsp">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>财务统计</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tables.jsp">
                        <i class="fas fa-fw fa-table"></i>
                        <span>设备管理</span></a>
                </li>
            </ul>

            <div id="content-wrapper">
                <div class="container-fluid">
                    <ng-view/>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.jsp">Logout</a>
            </div>
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
<script src="directives/dashboardTempletDirective.js?<%=System.currentTimeMillis()%>"></script>

<script src="controller/MainController.js?<%=System.currentTimeMillis()%>"></script>


</body>

</html>
