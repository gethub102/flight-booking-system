<%--
  Created by IntelliJ IDEA.
  User: wenbinli
  Date: 5/23/18
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<%@include file="navigation.jsp" %>
<%--<c:if test="${sessionScope.auth != 1}">--%>
<%--<c:redirect url="/auth/login.jsp"/>--%>
<%--</c:if>--%>
<div class="container">
    <div class="row">
        <h5>Add a flight</h5>
        <hr>
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
            <form action="/airplane/addAirPlane" , method="post">
                <div class="form-group">
                    <label for="producer">producer</label>
                    <input
                            type="text"
                            id="producer"
                            name="producer"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="type">type</label>
                    <input
                            type="text"
                            id="type"
                            name="type"
                            required
                            class="form-control">
                </div>

                <input type="submit" class="btn btn-primary col-sm-3" value="Add Airplane">
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>