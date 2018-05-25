<%@ include file="header.jsp" %>

<%@include file="navigation.jsp" %>
<c:if test="${sessionScope.auth != 1}">
    <c:redirect url="/auth/login.jsp"/>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
            <form action="/admin/updateProfile", method="post">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input
                            type="text"
                            id="firstName"
                            name="firstName"
                    <c:if test="${sessionScope.user.getFirstName() != null}">
                            value="${sessionScope.user.getFirstName()}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input
                            type="text"
                            id="lastName"
                            name="lastName"
                    <c:if test="${sessionScope.user.getLastName()!= null}">
                            value="${sessionScope.user.getLastName()}"
                    </c:if>
                            class="form-control">
                </div>

                <input type="submit" class="btn btn-primary col-sm-3" value="Update Profile">
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>