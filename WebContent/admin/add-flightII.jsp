<%@ page import="main.java.com.offer.service.RetreiveAirPlane" %>
<%@ page import="main.java.com.offer.service.RetreiveAirPlaneImpl" %>
<%@ page import="main.java.com.offer.domain.AirPlane" %>
<%@ page import="java.util.List" %><%--
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
            <form action="/flight/addFlightII" , method="post">
                <div class="form-group">
                    <label for="flightName">Flight Name</label>
                    <input
                            type="text"
                            id="flightName"
                            name="flightName"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="departureTime">Departure Time</label>
                    <input
                            type="text"
                            id="departureTime"
                            name="departureTime"
                            placeholder="--:--"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="departureDate">Departure Date</label>
                    <input
                            type="date"
                            id="departureDate"
                            name="departureDate"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="arrivalTime">Arrival Time</label>
                    <input
                            type="text"
                            id="arrivalTime"
                            name="arrivalTime"
                            required
                            class="form-control">
                </div>


                <div class="form-group">
                    <label for="arrivalDate">arrivalDate</label>
                    <input
                            type="date"
                            id="arrivalDate"
                            name="arrivalDate"
                            required
                            class="form-control">
                </div>


                <div class="form-group">
                    <label for="destination">Destination</label>
                    <input
                            type="text"
                            id="destination"
                            name="destination"
                            required
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="airplaneId">airplaneId</label>
                    <select name="airplaneId" id="airplaneId">


                        <%
                            RetreiveAirPlane retreiveAirPlane = new RetreiveAirPlaneImpl();
                            List<AirPlane> list = retreiveAirPlane.retreiveAirPlane();
                            System.out.println("this is a test in add flight");
                            for (AirPlane airPlane : list) {
                                int _id = airPlane.getAirplanId();
                                String _name = airPlane.getProducer() + " " + airPlane.getType();
                                System.out.println(_id + " " + _name);
                        %>
                        <%--<option value="${_id}"><% out.print(_name); %></option>--%>
                        <option value="<% out.print(_id); %>"><% out.print(_name); %></option>
                        <%
                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="departureCity">departureCity</label>
                    <input
                            type="text"
                            id="departureCity"
                            name="departureCity"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="arrivalCity">arrivalCity</label>
                    <input
                            type="text"
                            id="arrivalCity"
                            name="arrivalCity"
                            required
                            class="form-control">
                </div>
                <div class="form-group">
                    <label for="classA">Seat class A</label>
                    <input
                            type="text"
                            id="classA"
                            name="classA"
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="classAPirce">classAPirce</label>
                    <input
                            type="text"
                            id="classAPirce"
                            name="classAPirce"
                            required
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="classB">Seat class B</label>
                    <input
                            type="text"
                            id="classB"
                            name="classB"
                            required
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="classBPirce">classBPirce</label>
                    <input
                            type="text"
                            id="classBPirce"
                            name="classBPirce"
                            required
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="classC">Seat class C</label>
                    <input
                            type="text"
                            id="classC"
                            name="classC"
                            required
                            class="form-control">
                </div>

                <div class="form-group">
                    <label for="classCPirce">classCPirce</label>
                    <input
                            type="text"
                            id="classCPirce"
                            name="classCPirce"
                            required
                            class="form-control">
                </div>

                <input type="submit" class="btn btn-primary col-sm-3" value="Add FlightII">
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>