<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand">Home</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Booking History</a></li>
                <li><a href="admin-profile.jsp">Profile</a></li>
                <li><a href="add-flight.jsp">Add Flight</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.auth!=1}">
                    <li>
                        <a href="login.jsp">Login</a>
                    </li>
                    <li>
                        <a href="register.jsp">Register</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.auth == 1}">
                    <li><a href="logout.jsp">Logout</a></li>
                </c:if>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" role="button">Manage <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Save Data</a></li>
                        <li><a href="#">Fetch Data</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>