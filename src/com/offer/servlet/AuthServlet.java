package com.offer.servlet;

import com.offer.domain.Passenger;
import com.offer.service.AuthService;
import com.offer.service.AutheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/AuthServlet")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        System.out.println(firstName + "  " + lastName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Passenger passenger = new Passenger(email, password);
        AuthService authService = new AutheServiceImpl();
        if ((passenger = authService.login(passenger)) != null) {
            request.getSession().setAttribute("auth", 1);
            request.getSession().setAttribute("user", passenger);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
