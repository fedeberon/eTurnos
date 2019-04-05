<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Main Header -->
<header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>C.</b>C.B.</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Turnos </b>C.C.I.B.</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- The user image in the navbar-->
                        <img src="<c:url value='/resources/dist/img/avatar5.png'/>" class="user-image" alt="Usuario">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs"><sec:authentication property="principal.nombre" /></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header">
                            <img src="<c:url value='/resources/dist/img/avatar5.png'/>" class="img-circle" alt="Usuario">

                            <p>
                                <sec:authentication property="principal" />
                                <small>Rol <sec:authentication property="principal.rol" /></small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Atendidos</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Rellamadas</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Todos</a>
                                </div>
                            </div>
                            <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Perfil</a>
                            </div>
                            <div class="pull-right">
                                <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-default btn-flat">Log out</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <%--<li>--%>
                    <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
                <%--</li>--%>
            </ul>
        </div>
    </nav>
    </header>