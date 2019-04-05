<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<jsp:include page="../header.jsp"/>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="../panel-usuario.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Parametros<small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Parametros</a></li>
                <li class="active">show</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Parametros</h3>
                        </div>
                        <!-- /.box-header -->
                        <form:form modelAttribute="parametro" action="/turnos/parametros/save">
                            <div class="box-body">
                                <table id="parametro" class="table table-bordered table-hover">
                                    <tbody>
                                        <tr>
                                            <th>Cod Int</th>
                                            <td>
                                                <form:hidden path="id"/>
                                                <label>${parametro.id}</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Nombre</th>
                                            <td>
                                                <form:hidden path="nombre"/>
                                                <label>${parametro.nombre}</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Valor</th>
                                            <td><form:input path="valor"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>


                            <div class="col-xs-12">
                                <sec:authorize access="hasAnyRole('ROLE_CONFIG','ROLE_ADMIN')">
                                    <div class="col-xs-2">
                                        <button type="submit" class="btn btn-block btn-primary">
                                            Guardar
                                        </button>
                                    </div>
                                </sec:authorize>
                            </div>


                        </form:form>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->

            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
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
