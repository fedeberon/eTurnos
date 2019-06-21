<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="control-sidebar control-sidebar-dark">
    <!-- Tab panes -->
    <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane active" id="control-sidebar-home-tab">
            <ul class="control-sidebar-menu">
                <li>
                    <a href="<c:url value="/j_spring_security_logout" />">
                        <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">Logout</h4>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <!-- /.tab-pane -->
    </div>
</aside>
