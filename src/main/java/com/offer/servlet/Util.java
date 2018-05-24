package main.java.com.offer.servlet;

import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;

import javax.servlet.http.HttpServletRequest;

public class Util {
    public static Passenger createUpdateProfileObj(HttpServletRequest request) {
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

    public static Passenger createRegisterProfileObj(HttpServletRequest request) {
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String age_str = request.getParameter("age");
        int age = age_str.trim().length() == 0 ? 0 : Integer.parseInt(age_str);
//        int age = Integer.parseInt(request.getParameter("age") ==  "" ? 0);
        String street = request.getParameter("street");
        String apartmentNumber = request.getParameter("apartmentNumber");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String telHome = request.getParameter("telHome");
        String telOffice = request.getParameter("telOffice");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Passenger passenger = new Passenger(fname, lname, age, ssn, street, apartmentNumber, city, state, zip, telHome, telOffice, email);
        passenger.setPassword(password);
        System.out.println(passenger);
        return passenger;
    }

    public static Admin createUpdateAdminProfileObj(HttpServletRequest request) {
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
        Admin admin = new Admin(fname, lname, age, ssn, street, apartmentNumber, city, state, zip, telHome, telOffice, email);
        int passengerId = ((Passenger)request.getSession().getAttribute("user")).getId();
        admin.setId(passengerId);
        System.out.println(admin);
        return admin;
    }
}
