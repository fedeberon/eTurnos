<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="header.jsp"/>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Gesti&oacute;n de Turnos</b><br/>Camara Comercial de Bolivar</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Login</p>

    <form  name='f' action='/turnos/j_spring_security_check' method='POST'>
      <div class="form-group has-feedback">
        <input type="text" name='j_username' class="form-control" placeholder="Usuario">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name='j_password' class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>

        <div class="row">

            <div class="col-xs-12">
                <div class="form-group has-feedback">
                    <select  name="puestoDeAtencion" class="form-control">
                        <c:forEach items="${puestosDisponibles}" var="bo">
                            <option value="${bo.id}">${bo.hostname} ${bo.numero}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

        <!-- /.col -->
        <div class="col-xs-6">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Ingresar</button>
        </div>
        <!-- /.col -->

          <div class="col-xs-6">
              <c:if test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
                  <div class="error">
                      ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                  </div>
              </c:if>

          </div>


      </div>
    </form>


  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/resources/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<c:url value='/webjarslocator/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/plugins/iCheck/icheck.min.js'/>"></script>

<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>

</body>
</html>
