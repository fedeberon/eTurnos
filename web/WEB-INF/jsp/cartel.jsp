<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


    <!-- Bootstrap 3.3.5 -->
    <script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
    <script src="<c:url value='/resources/plugins/websocket/sockjs.js'/>"></script>
    <script src="<c:url value='/resources/plugins/websocket/stomp.js'/>"></script>
    <script src="<c:url value='/resources/websocket/websocket.js'/>"></script>
    <script src="<c:url value='/resources/cartel/videoPlayer.js'/>"></script>

    <script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
    <script>
        $(function () {
            onload();
        });
    </script>

    <style>
        .turno-box {
            background-color: #94a5fb;
            margin: 5px;
            padding: 15px;
            font-size: 25px;
            transition: 1s;
            display: none;
        }
        .cabecera {
            margin: 5px;
            padding: 15px;
            font-size: 35px;
        }
        video{
            width:100%
        }
    </style>


    <%--<link rel="stylesheet" type='text/css' href="<c:url value='/webjarslocator/bootstrap/css/bootstrap.min.css'/>"/>--%>
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/bootstrap.min.css'/>">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/font-awesome.min.css'/>">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/ionicons.min.css'/>">
    <!-- jvectormap -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/jquery-jvectormap-1.2.2.css'/>">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/AdminLTE.min.css'/>">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value='/resources/cartel/css/_all-skins.min.css'/>">

</head>
<body onload="onload();">


    <div class="content-wrapper" style="min-height: 916px;">
        <!-- Content Header (Page header) -->

        <!-- Main content -->
        <section class="content">
            <!-- Info boxes -->
            <div class="row">
                <div class="col-md-5">

                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Turnos</h3>
                        </div>
                        <div id="turnos-content" class="box-body">
                            <div class="clearfix visible-sm-block"></div>

                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Publicidad</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                                <video id="idle_video"  onended="onVideoEnded()"></video>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>

    </div>

</body>



<audio autoplay="0" id="sonidoCartel">
    <source src="<c:url value='/resources/audios/bell_sound_effect.mp3'/>" type="audio/mpeg">
</audio>

<div id="turno-box-template" class="col-md-12">
    <div class="info-box">
        <span id="box-nro-turno" class="info-box-icon bg-yellow"></span>

        <div class="info-box-content">
            <span id="box-nro-caja" class="info-box-text"></span>
            <span id="box-cliente" class="info-box-number"></span>
        </div>
    </div>
</div>

</html>
