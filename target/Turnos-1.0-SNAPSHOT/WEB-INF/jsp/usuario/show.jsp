<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>
<head>
    <style>
        .modal-dialog{
            position: absolute;
            left: 50%;
            /* now you must set a margin left under zero - value is a half width your window */
            margin-left: -312px;
            /* this same situation is with height - example */
            height: 500px;
            top: 50%;
            margin-top: -250px;
        }
    </style>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Inicio<small>Usuarios</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Usuarios</a></li>
                <li class="active">Todos</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Usuario: ${usuario}</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="usuarios" class="table table-bordered table-hover">
                                <tbody>
                                <tr>
                                    <th>Cod Int</th>
                                    <td>${usuario.id}</td>
                                </tr>
                                <tr>
                                    <th>Username</th>
                                    <td>${usuario.username}</td>
                                </tr>
                                <tr>
                                    <th>Nombre</th>
                                    <td>${usuario.nombre}</td>
                                </tr>
                                <tr>
                                    <th>Apellido</th>
                                    <td>${usuario.apellido}</td>
                                </tr>
                                <tr>
                                    <th>D.N.I.</th>
                                    <td>${usuario.dni}</td>
                                </tr>
                                <tr>
                                    <th>Rol</th>
                                    <td>${usuario.rol}</td>
                                </tr>
                                <tr>
                                    <th>Ultimo loguin</th>
                                    <td>${usuario.lastLoguin}</td>
                                </tr>
                                <tr>
                                    <th>Estado</th>
                                    <td>
                                        <c:choose>
                                            <c:when test="${usuario.activo}">
                                                ACTIVO
                                            </c:when>
                                            <c:otherwise>
                                                INACTIVO
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col -->


                <div class="col-xs-12">
                    <div class="col-xs-2">
                        <a href="/turnos/usuarios/list" class="btn btn-block btn-primary">Atras</a>
                    </div>
                    <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                        <div class="col-xs-2">
                            <button type="button" class="btn btn-block btn-primary"  id="solicitarTurno" data-toggle="modal" data-target="#myModal">
                                Editar Rol de Usuario
                            </button>
                        </div>

                        <div class="col-xs-2">
                            <button type="button" class="btn btn-block btn-primary"  id="solicitarTurno" data-toggle="modal" data-target="#myModalDni">
                                Editar D.N.I. de Usuario
                            </button>
                        </div>

                        <div class="col-xs-2">
                            <c:choose>
                                <c:when test="${usuario.activo}">
                                    <a href="/turnos/usuarios/darDeBaja?id=${usuario.username}" class="btn btn-block btn-danger">
                                        Dar de baja
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/turnos/usuarios/activar?id=${usuario.username}" class="btn btn-block btn-primary">
                                        Activar
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </sec:authorize>
                    <div class="col-xs-2">
                        <a href="/turnos/usuarios/exportarCredencial?id=${usuario.id}" onclick="$('#Searching_Modal').modal('show')"  class="btn btn-block btn-primary">Exportar Credencial</a>
                    </div>

                </div>
                </div>

            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->



    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">

            <form action="<c:url value='/usuarios/editRol'/>">
                <input type="hidden" value="${usuario.username}" name="id">
            <div class="modal-content">

                <div class="modal-header">
                    <h3 class="modal-title">Editar Rol de Usuario a ${usuario}</h3>
                </div>

                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <select class="form-control" name="rol">
                                <c:forEach items="${roles}" var="rol">
                                    <option value="${rol.id}">${rol.id} - ${rol.function}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="myModalDni" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">

            <form action="<c:url value='/usuarios/save'/>">
                <input type="hidden" value="${usuario.username}" name="id">
                <div class="modal-content">

                    <div class="modal-header">
                        <h3 class="modal-title">Editar D.N.I de Usuario a ${usuario}</h3>
                    </div>

                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <input type="text" name="dni" placeholder="Ingrese el DNI" value="${usuario.dni}"/>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
            </form>
        </div>
    </div>
    </div>

<div id="Searching_Modal" class="modal fade" tabindex="-1" role="dialog" data-keyboard="false"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="text-align: center">
                <h3>Creando Credencial ...</h3>
            </div>
            <div class="modal-body" >
                <br>
                <br>
                <br>
                <div id="searching_spinner_center" style="position:fixed; left:50%"></div>
                <br>
                <br>
                <br>
            </div>
            <div class="modal-footer" style="text-align: center"></div>
        </div>
    </div>
</div>



    <jsp:include page="../footer.jsp"/>

    <jsp:include page="../menu-derecho.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- DataTables -->
<script src="<c:url value='/resources/plugins/datatables/jquery.dataTables.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/dist/js/app.min.js'/>"></script>

</body>
</html>
