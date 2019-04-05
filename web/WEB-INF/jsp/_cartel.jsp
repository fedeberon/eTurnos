<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Turnos C&aacute;mara comercial</title>
    <meta content="<?=$descripcion;?>" name=description>
    <meta content="<?=$keywords;?>parte mia, marca parte mia" name=keywords>
    <meta content="INDEX, FOLLOW" name=GOOGLEBOT>
    <meta content=global name=distribution>
    <meta content=General name=rating>
    <meta content="2 days" name=revisit-after>
    <meta content=document name=resource-type>
    <meta content=all name=robots>
    <meta http-equiv=Content-Language content=es>

    <script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
    <%--<script src="http://code.jquery.com/jquery-1.11.1.js" type="text/javascript"></script>--%>
    <script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/plugins/websocket/sockjs.js'/>"></script>
    <script src="<c:url value='/resources/plugins/websocket/stomp.js'/>"></script>
    <script src="<c:url value='/resources/cartel/videoPlayer.js'/>"></script>
    <script src="<c:url value='/resources/websocket/websocket.js'/>"></script>

    <!-- Bootstrap -->
    <link href="<c:url value='/resources/display/css/bootstrap.min.css'/>" rel="stylesheet" media="screen">
    <%--<link href="css/bootstrap.css" rel="stylesheet" media="screen">--%>
    <link href="<c:url value='/resources/display/css/bootstrap-theme.min.css'/>" rel="stylesheet" media="screen">
    <%--<link href="css/bootstrap-theme.css" rel="stylesheet" media="screen">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <link href="<c:url value='/resources/display/css/turnos.css'/>" rel="stylesheet" media="screen">

    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,700,300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Yellowtail' rel='stylesheet' type='text/css'>



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script>var ctx = "${pageContext.request.contextPath}";</script>
</head>
<body onload="onload();">

<div class="content">
    <div  class="col1">
        <div class="head-turnos">
            <div class="numero">N&uacute;mero</div>
            <div class="caja">Caja</div>
            <div class="spacer"></div>
        </div>
        <div id="turnos-content">

        </div>
    </div>

    <div class="col2">
            <video id="idle_video" style="width: 100%; height: 100%;" onended="onVideoEnded()"></video>
    </div>

    <div class="spacer"></div>
</div>

<audio autoplay="0" id="sonidoCartel">
    <source src="<c:url value='/resources/audios/bell_sound_effect.mp3'/>" type="audio/mpeg">
</audio>

<div id="turno-box-template" class="turno" style="display: none;">
    <div id="box-nro-turno" class="numero"></div>
    <div id="box-nro-caja" class="caja"></div>
    <div class="spacer"></div>
</div>

</body>
</html>