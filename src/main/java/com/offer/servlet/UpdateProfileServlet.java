package main.java.com.offer.servlet;


import main.java.com.offer.domain.Passenger;
import main.java.com.offer.service.UpdateProfileService;
import main.java.com.offer.service.UpdateProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger passenger = Util.createUpdateProfileObj(request);
        UpdateProfileService updateProfileService = new UpdateProfileServiceImpl();
        if ((passenger = updateProfileService.updateProfile(passenger)) != null) {
            System.out.println("update profile success");
            request.getSession().setAttribute("user", passenger);
        } else {
            System.out.println("update profile failed");
            System.out.println(passenger);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
