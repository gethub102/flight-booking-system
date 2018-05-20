package com.offer.servlet;

import com.offer.domain.Passenger;
import com.offer.service.UpdateProfileService;
import com.offer.service.UpdateProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger passenger = this.createUpdateProfileObj(request);
        UpdateProfileService updateProfileService = new UpdateProfileServiceImpl();
        if ((passenger = updateProfileService.updateProfile(passenger)) != null) {
            System.out.println("update profile success");
            request.getSession().setAttribute("user", passenger);
        } else {
            System.out.println("update profile failed");
            System.out.println(passenger);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Passenger createUpdateProfileObj(HttpServletRequest request) {
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        int age = Integer.parseInt(request.getParameter("age"));
        String street = request.getParameter("street");
        String apartmentNumber = request.getParameter("apartmentNumber");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String telHome = request.getParameter("telHome");
        String telOffice = request.getParameter("telOffice");
        String email = request.getParameter("email");
        Passenger passenger = new Passenger(fname, lname, age, ssn, street, apartmentNumber, city, state, zip, telHome, telOffice, email);
        int passengerId = ((Passenger)request.getSession().getAttribute("user")).getId();
        passenger.setId(passengerId);
        System.out.println(passenger);
        return passenger;
    }
}
