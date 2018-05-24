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
                <div class="form-group">
                    <label for="email">Mail</label>
                    <input
                            type="email"
                            id="email"
                            name="email"
                    <c:if test="${sessionScope.user.email != null}">
                            value="${sessionScope.user.email}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="ssn">SSN</label>
                    <input
                            type="text"
                            id="ssn"
                            name="ssn"
                    <c:if test="${sessionScope.user.ssn != null}">
                            value="${sessionScope.user.ssn}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="age">Age</label>
                    <input
                            type="text"
                            id="age"
                            name="age"
                    <c:if test="${sessionScope.user.getAge() != null}">
                            value="${sessionScope.user.getAge()}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="street">Street</label>
                    <input
                            type="text"
                            id="street"
                            name="street"
                    <c:if test="${sessionScope.user.street != null}">
                            value="${sessionScope.user.street}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="apartmentNumber">Apartment Number</label>
                    <input
                            type="text"
                            id="apartmentNumber"
                            name="apartmentNumber"
                    <c:if test="${sessionScope.user.apartmentNumber != null}">
                            value="${sessionScope.user.apartmentNumber}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input
                            type="text"
                            id="city"
                            name="city"
                    <c:if test="${sessionScope.user.city != null}">
                            value="${sessionScope.user.city}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="state">State</label>
                    <input
                            type="text"
                            id="state"
                            name="state"
                    <c:if test="${sessionScope.user.state != null}">
                            value="${sessionScope.user.state}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="zip">Zip</label>
                    <input
                            type="text"
                            id="zip"
                            name="zip"
                    <c:if test="${sessionScope.user.zip != null}">
                            value="${sessionScope.user.zip}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="telHome">Home Phone</label>
                    <input
                            type="text"
                            id="telHome"
                            name="telHome"
                    <c:if test="${sessionScope.user.telHome != null}">
                            value="${sessionScope.user.telHome}"
                    </c:if>
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="telOffice">Office Phone</label>
                    <input
                            type="text"
                            id="telOffice"
                            name="telOffice"
                    <c:if test="${sessionScope.user.telOffice != null}">
                            value="${sessionScope.user.telOffice}"
                    </c:if>
                            class="form-control">
                </div>
                <input type="submit" class="btn btn-primary col-sm-3" value="Update Profile">
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>