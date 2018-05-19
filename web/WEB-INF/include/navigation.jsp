<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/index.jsp" class="navbar-brand">Home</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Booking History</a></li>
                <li><a href="#">Profile</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:set var="auth" value="1" scope="session"></c:set>

                <c:if test="${sessionScope.auth==1}">
                    <li>
                        <a href="/auth/login.jsp">Login</a>
                    </li>
                    <li>
                        <a href="/auth/register.jsp">Register</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.auth != 1}">
                    <c:out value="${sessionScope.auth}"></c:out>
                    <li><a href="#">Logout</a></li>
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