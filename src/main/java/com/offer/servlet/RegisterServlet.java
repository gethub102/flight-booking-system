package main.java.com.offer.servlet;

import main.java.com.offer.domain.Passenger;
import main.java.com.offer.service.AuthService;
import main.java.com.offer.service.AuthServiceImpl;
import main.java.com.offer.service.UpdateProfileService;
import main.java.com.offer.service.UpdateProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger passenger = Util.createRegisterProfileObj(request);
        System.out.println("in the servlet " + passenger); // => test code
        AuthService authService = new AuthServiceImpl();
        if ((passenger = authService.register(passenger)) != null) {
            System.out.println("register profile success");
            request.getSession().setAttribute("user", passenger);
            request.getSession().setAttribute("auth", 1);
        } else {
            System.out.println("register profile failed");
            System.out.println(passenger);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
