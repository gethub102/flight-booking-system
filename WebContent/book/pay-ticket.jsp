<%@ page import="main.java.com.offer.domain.Flight" %>
<%@ page import="main.java.com.offer.domain.Passenger" %>
<%@ include file="/WEB-INF/include/header.jsp" %>

<%@include file="/WEB-INF/include/navigation.jsp" %>
<c:if test="${sessionScope.auth != 1}">
<c:redirect url="/auth/login.jsp"/>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">

            <div>
                <% Flight flight = (Flight) session.getAttribute("bookingTicket"); %>
                FlightName:<% out.println("    " + flight.getFlightName()); %> <br>
                DepartureTime:<% out.print("   " + flight.getDepartureTime() + " "); %>
                DepartureDate: <% out.println(" " + flight.getDepartureDate()); %> <br>
                ArrivalTime:<% out.print("     " + flight.getArrivalTime() + " "); %>
                ArrivalDate:   <% out.println(" " + flight.getArrivalDate()); %> <br>
                AirplaneId:<% out.println("    " + flight.getAirplaneId()); %> <br>
                DepartureCity:<% out.println(" " + flight.getDepartureCity()); %> <br>
                ArrivalCity:<% out.println("   " + flight.getArrivalCity()); %> <br>
                ClassA:<% out.print("          " + flight.getClassA() + " "); %>
                Price: <% out.println(" " + flight.getClassAPirce()); %> <br>
                ClassB:<% out.print("          " + flight.getClassB() + " "); %>
                Price: <% out.println(" " + flight.getClassBPirce()); %> <br>
                ClassC:<% out.print("          " + flight.getClassC() + " "); %>
                Price: <% out.println(" " + flight.getClassCPirce()); %> <br>

                <%
                    Passenger passenger = ((Passenger)session.getAttribute("user"));
                    System.out.println("id is " + passenger.getId());
                %>

                <hr>
                <form action="/book/placeorder" method="post">
                    <div class="form-group">
                        <label for="count">Count</label>
                        <input
                                type="number"
                                id="count"
                                name="count"
                                required
                                placeholder="count of ticket"
                                class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="class">Class</label>
                        <select name="class" id="class">
                            <option value="classA">A</option>
                            <option value="classB">B</option>
                            <option value="classC">C</option>
                        </select>
                    </div>


                    <div class="form-group">
                        <label for="baggage" >baggage</label>
                        <input
                                type="text"
                                id="baggage"
                                name="baggage"
                                required
                                placeholder="count of ticket"
                                class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="passengerId" hidden>passengerId</label>
                        <input
                                type="hidden"
                                id="passengerId"
                                name="passengerId"
                                value="<% out.print(passenger.getId()); %>"
                                placeholder="count of ticket"
                                class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="flightNumber" hidden>flightNumber</label>
                        <input
                                type="hidden"
                                id="flightNumber"
                                name="flightNumber"
                                value="<% out.print(flight.getFlightNumber()); %>"
                                placeholder="count of ticket"
                                class="form-control">
                    </div>

                    <input type="submit" class="btn btn-primary col-sm-3" value="Place Order">
                </form>

            </div>

        </div>
    </div>
</div>


<%@ include file="/WEB-INF/include/footer.jsp" %>