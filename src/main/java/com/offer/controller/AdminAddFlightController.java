package main.java.com.offer.controller;

import main.java.com.offer.domain.Flight;
import main.java.com.offer.utils.CustomDateMidnightEditor;
import main.java.com.offer.utils.CustomTimeEditor;
import org.joda.time.DateMidnight;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;



@Controller
@RequestMapping("/flight")
public class AdminAddFlightController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        try {


//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
//        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        DateTimeFormatter stf = DateTimeFormatter.ofPattern("HH:mm a");
//            sdf.setLenient(true);
//        stf.setLenient(true);
            System.out.println("in the init binder");
//            binder.registerCustomEditor(LocalTime.class, "departureTime", new CustomDateEditor(sdf, true));
//        binder.registerCustomEditor(Date.class, "departureTime", new CustomDateEditor(sdf, true));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(stf, true));

//        binder.setDisallowedFields(new String[]{"date", "time"});



            final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MM/dd/yyyy").toFormatter();
            binder.registerCustomEditor(DateMidnight.class, new CustomDateMidnightEditor(formatter, false));

            final DateTimeFormatter formatter2 = new DateTimeFormatterBuilder().appendPattern("HH:mm aa").toFormatter();
            binder.registerCustomEditor(LocalTime.class, new CustomTimeEditor(formatter2, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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
}
