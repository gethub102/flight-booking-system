<%@ page import="main.java.com.offer.service.RetrieveFlight" %>
<%@ page import="main.java.com.offer.service.RetrieveFlightImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.offer.domain.Flight" %>
<%@ include file="/WEB-INF/include/header.jsp" %>

<%@include file="/WEB-INF/include/navigation.jsp" %>
<%--<c:if test="${sessionScope.auth != 1}">--%>
<%--<c:redirect url="/auth/login.jsp"/>--%>
<%--</c:if>--%>
<div class="container">
    <div class="row">
        <%--<div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">--%>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">flightName</th>
                    <th scope="col">departureTime</th>
                    <th scope="col">departureDate</th>
                    <th scope="col">arrivalTime</th>
                    <th scope="col">arrivalDate</th>
                    <th scope="col">departureCity</th>
                    <th scope="col">arrivalCity</th>
                    <th scope="col">classA</th>
                    <th scope="col">Price</th>
                    <th scope="col">classB</th>
                    <th scope="col">Price</th>
                    <th scope="col">classC</th>
                    <th scope="col">Price</th>
                    <th scope="col">Book</th>
                </tr>
                </thead>
                <tbody>

                <%
                    RetrieveFlight retrieveFlight = new RetrieveFlightImpl();
                    List<Flight> flights = retrieveFlight.retrieveFlights();

                    for (Flight flight : flights) {
                        System.out.println(" time is " + flight.getDepartureTime());
                %>

                <tr>
                    <td>
                        <% out.print(flight.getFlightNumber());%>
                    </td>
                    <td>
                        <% out.print(flight.getFlightName());%>
                    </td>
                    <td>
                        <% out.print(flight.getDepartureTime());%>
                    </td>
                    <td>
                        <% out.print(flight.getDepartureDate());%>
                    </td>
                    <td>
                        <% out.print(flight.getArrivalTime());%>
                    </td>
                    <td>
                        <% out.print(flight.getDepartureDate());%>
                    </td>
                    <td>
                        <% out.print(flight.getDepartureCity());%>
                    </td>
                    <td>
                        <% out.print(flight.getArrivalCity());%>
                    </td>
                        <%--<td><span class="badge" (click)="onAddToFavorite(i)" >{{ music.addFavoriteStatus ? 'Added' : 'Add' }}</span></td>--%>
                    <td><span class="badge"><% out.print(flight.getClassA());%></span></td>
                    <td><span class="badge"><% out.print(flight.getClassAPirce());%></span></td>
                    <td><span class="badge"><% out.print(flight.getClassB());%></span></td>
                    <td><span class="badge"><% out.print(flight.getClassBPirce());%></span></td>
                    <td><span class="badge"><% out.print(flight.getClassC());%></span></td>
                    <td><span class="badge"><% out.print(flight.getClassCPirce());%></span></td>
                    <% session.setAttribute("bookingTicket", flight); %>
                    <td><a href="pay-ticket.jsp"><button class="btn btn-link btn-xs">Book</button></a> </td>
                </tr>

                <%
                    }
                %>
                </tbody>
            </table>

        <%--</div>--%>
    </div>
</div>


<%@ include file="/WEB-INF/include/footer.jsp" %>