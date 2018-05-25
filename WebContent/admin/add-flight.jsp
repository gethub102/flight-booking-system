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
            <form action="/flight/addFlight", method="post">
                <div class="form-group">
                    <label for="flightName">Flight Name</label>
                    <input
                            type="text"
                            id="flightName"
                            name="flightName"
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="departureTime">Departure Time</label>
                    <input
                            type="time"
                            id="departureTime"
                            name="departureTime"
                            class="form-control">
                </div>
                <%--<div class="form-group">--%>
                    <%--<label for="departureDate">Departure Date</label>--%>
                    <%--<input--%>
                            <%--type="date"--%>
                            <%--id="departureDate"--%>
                            <%--name="departureDate"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="arrivalTime">Arrival Time</label>--%>
                    <%--<input--%>
                            <%--type="time"--%>
                            <%--id="arrivalTime"--%>
                            <%--name="arrivalTime"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>


                <%--<div class="form-group">--%>
                    <%--<label for="arrivalDate">arrivalDate</label>--%>
                    <%--<input--%>
                            <%--type="date"--%>
                            <%--id="arrivalDate"--%>
                            <%--name="arrivalDate"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>


                <%--<div class="form-group">--%>
                    <%--<label for="destination">Destination</label>--%>
                    <%--<input--%>
                            <%--type="text"--%>
                            <%--id="destination"--%>
                            <%--name="destination"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="airplaneId">airplaneId</label>--%>
                    <%--<input--%>
                            <%--type="text"--%>
                            <%--id="airplaneId"--%>
                            <%--name="airplaneId"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="departureCity">departureCity</label>--%>
                    <%--<input--%>
                            <%--type="text"--%>
                            <%--id="departureCity"--%>
                            <%--name="departureCity"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="arrivalCity">arrivalCity</label>--%>
                    <%--<input--%>
                            <%--type="text"--%>
                            <%--id="arrivalCity"--%>
                            <%--name="arrivalCity"--%>
                            <%--class="form-control">--%>
                <%--</div>--%>

                <input type="submit" class="btn btn-primary col-sm-3" value="Add Flight">
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>