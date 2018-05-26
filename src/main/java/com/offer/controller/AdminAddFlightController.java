package main.java.com.offer.controller;

import main.java.com.offer.domain.Flight;
import main.java.com.offer.service.AddFlightService;
import main.java.com.offer.service.AddFlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;



@Controller
@RequestMapping("/flight")
public class AdminAddFlightController {

    AddFlightService addFlightService = new AddFlightServiceImpl();

    @RequestMapping(path = "/addFlight", method = RequestMethod.POST)
    public String addFlight(@ModelAttribute("flight") Flight flight, HttpServletRequest request, @RequestBody String postPayload, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
        }
        System.out.println("admin is adding a flight");
        System.out.println("payload " + postPayload);
//        System.out.println("flight " + flight.getFlightName());
//        String flightName = request.getParameter("flightName");
//        String arrivalTime = request.getParameter("arrivalTime");
//        String arrivalDate = request.getParameter("arrivalDate");
//        String departureTime = request.getParameter("departureTime");
//        String departureDate = request.getParameter("departureDate");
//        String destination = request.getParameter("destination");
//        String airplaneId = request.getParameter("airplaneId");
//        String departureCity = request.getParameter("departureCity");
//        String arrivalCity = request.getParameter("arrivalCity");
//        System.out.println("flightName " + flightName);
//        System.out.println("arrivalTime " + arrivalTime);
//        System.out.println("arrivalDate " + arrivalDate);
//        System.out.println("departureTime " + departureTime);
//        System.out.println("departureDate " + departureDate);
//        System.out.println("destination " + destination);
//        System.out.println("airplaneId " + airplaneId);
//        System.out.println("departureCity " + departureCity);
//        System.out.println("arrivalCity " + arrivalCity);


        return "/admin/scheduledFlight";
    }

    @RequestMapping(path = "/addFlightII", method = RequestMethod.POST)
    public ModelAndView addFlightII(Flight flight, HttpServletRequest request, @RequestBody String postPayload, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
        }
        System.out.println("this is a add flight II");
        System.out.println(postPayload);

        System.out.println(request.getParameter("departureTime"));

        System.out.println("done");


        String flightName = request.getParameter("flightName");
        String arrivalTime = request.getParameter("arrivalTime");
        String arrivalDate = request.getParameter("arrivalDate");
        String departureTime = request.getParameter("departureTime");
        String departureDate = request.getParameter("departureDate");
        String destination = request.getParameter("destination");
        String airplaneId = request.getParameter("airplaneId");
//        int classA = StringUtils.isEmpty(request.getParameter("classA")) ? 0 : Integer.parseInt(request.getParameter("classA"));
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        int classA = StringUtils.isEmpty(request.getParameter("classA")) ? 0 : Integer.parseInt(request.getParameter("classA"));
        int classB = StringUtils.isEmpty(request.getParameter("classB")) ? 0 : Integer.parseInt(request.getParameter("classA"));
        int classC = StringUtils.isEmpty(request.getParameter("classC")) ? 0 : Integer.parseInt(request.getParameter("classA"));

        System.out.println("this is a test for airplaneId = " + airplaneId);

        flight.setFlightName(flightName);
        flight.setArrivalTime(arrivalTime);
        flight.setArrivalDate(arrivalDate);
        flight.setDepartureTime(departureTime);
        flight.setDepartureDate(departureDate);
        flight.setDestination(destination);
        flight.setAirplaneId(Integer.parseInt(airplaneId));
        flight.setDepartureCity(departureCity);
        flight.setArrivalCity(arrivalCity);
        flight.setClassA(classA);
        flight.setClassB(classB);
        flight.setClassC(classC);



        ModelAndView mv = new ModelAndView("/admin/scheduledFlight");
        mv.addObject(flight);


        // add flight to db
        if (addFlightService.addFlight(flight) != null) {
            System.out.println("add flight success");
        }
        // retreive data from database


        return mv;
    }

    @RequestMapping(path = "/addFlightIII", method = RequestMethod.GET)
    public String test() {
        System.out.println("this is a test");
        return "/admin/scheduledFlight";
    }
}
