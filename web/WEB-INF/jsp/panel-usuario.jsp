<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<c:url value='/resources/dist/img/avatar5.png'/>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><sec:authentication property="principal.username" /></p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Buscar...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">

            <sec:authorize access="hasAnyRole('ROLE_USER' , 'ROLE_CONFIG')">
                <li class="header"><a href="<c:url value='/turno/panel'/>">LLAMADAS DE TURNOS</a></li>
            </sec:authorize>


            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <!-- Optionally, you can add icons to the links -->
                <li class="treeview">
                    <a href="#"><i class="fa fa-users"></i> <span>Usuarios</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/usuarios/list'/>">Todos</a></li>
                        <%--<li><a href="<c:url value='/usuarios/create'/>">Nuevo</a></li>--%>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa fa-th-list"></i> <span>Socios</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/socio/list'/>">Todos</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa  fa-desktop"></i> <span>Puestos de Atenci&oacute;n</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/puestoDeAtencion/list'/>">Todos</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa fa-ticket"></i> <span>Turnos</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/turno/list'/>">Todos</a></li>
                        <li><a href="<c:url value='/turno/turnosOrdenados'/>">Por Orden de llamada</a></li>
                        <li><a href="<c:url value='/estadistica/consultas'/>">Gr&aacute;ficos</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa fa-picture-o"></i> <span>Banners</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/banner/list'/>">Todos</a></li>
                        <li><a href="<c:url value='/banner/formUpload'/>">Nuevo</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa fa-bell"></i> <span>Notificaciones</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value=''/>">Nueva</a></li>
                        <li><a href="<c:url value=''/>">Todas</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                <li class="treeview">
                    <a href="#"><i class="fa fa-list-ol"></i> <span>Parametros</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value='/parametros/show?id=1'/>">Alternancia</a></li>
                    </ul>
                </li>
            </sec:authorize>




        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>