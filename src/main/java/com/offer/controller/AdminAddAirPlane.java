package main.java.com.offer.controller;

import main.java.com.offer.domain.AirPlane;
import main.java.com.offer.service.AddAirPlane;
import main.java.com.offer.service.AddAirPlaneImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/airplane")
public class AdminAddAirPlane {
    @RequestMapping(path = "/addAirPlane", method = RequestMethod.POST)
    public String addAirPlane(@ModelAttribute("airplane")AirPlane airPlane) {
        AddAirPlane addAirPlane = new AddAirPlaneImpl();
        addAirPlane.addAirPlane(airPlane);
        return "/admin/addAirPlane";
    }

    // test add airplane
    // test add flight
    // test retrieve air plane
}
