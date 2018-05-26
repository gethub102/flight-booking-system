package main.java.com.offer.controller;

import main.java.com.offer.domain.Booking;
import main.java.com.offer.domain.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class PassengerBooking {

    @RequestMapping(path = "/scheduled", method = RequestMethod.GET)
    public String getScheduledFlight() {
        System.out.println("this is a test for /book/scheduled controller");
        return "/book/scheduled-flight";
    }

    @RequestMapping(path = "/placeorder", method = RequestMethod.POST)
    public String placeOrder(Booking booking, HttpServletRequest request) {
        System.out.println("in the place ordering ... ");
        int count = Integer.parseInt(request.getParameter("count"));
        String classType = request.getParameter("class");
        String baggage = request.getParameter("baggage");
        int passengerId = Integer.parseInt(request.getParameter("passengerId"));
        int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));

        booking.setClasstype(classType);
        booking.setBaggage(baggage);
        booking.setPassengerId(passengerId);
        booking.setFlightNumber(flightNumber);
        booking.setStatus("booking");


//        booking.set

        return "/book/orderStatus";
    }
}
