package main.java.com.offer.controller;

import main.java.com.offer.domain.Admin;
import main.java.com.offer.domain.Passenger;
import main.java.com.offer.service.AuthService;
import main.java.com.offer.service.AuthServiceImpl;
import main.java.com.offer.service.UpdateProfileService;
import main.java.com.offer.service.UpdateProfileServiceImpl;
import main.java.com.offer.servlet.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAuthController {

    @RequestMapping(path = "/")
    public String adimIndexHome() {
        return "/admin/index";
    }

    @RequestMapping(path = "/login")
    public String adminLoginPage() {
        return "/admin/login";
    }

    @RequestMapping(path = "/register")
    public String adminRegisterPage() {
        return "/admin/register";
    }

    @RequestMapping(path = "/loginPost")
    public String loginPost(@ModelAttribute("admin") Admin admin, HttpServletRequest request) {
//        System.out.println("this is a process login for admin");
//        String email = admin.getEmail();
//        String password = admin.getPassword();
//        System.out.println("email = " + email);
        //Admin _admin = new Admin(email, password);
        AuthService authService = new AuthServiceImpl();
        if ((admin = authService.adminLogin(admin)) != null) {
            request.getSession().setAttribute("auth", 1);
//            System.out.println("admin controller line 45: id = " + admin.getId());
            request.getSession().setAttribute("user", admin);
        }
        return "/admin/index";
    }

    @RequestMapping(path = "/updateProfile")
    public String updateAdminProfile(@ModelAttribute("admin") Admin admin, HttpServletRequest request) {
        int idd = ((Admin)request.getSession().getAttribute("user")).getId();
        admin.setId(idd);
        UpdateProfileService updateProfileService = new UpdateProfileServiceImpl();
        if ((admin = updateProfileService.updateAdminProfile(admin)) != null) {
            System.out.println("update profile success");
            request.getSession().setAttribute("user", admin);
            int id = ((Admin) request.getSession().getAttribute("user")).getId();
            System.out.println("admin auth controller line 58,  id is " + id);
        } else {
            System.out.println("update profile failed");
            System.out.println(admin);
        }
        return "/admin/admin-profile";
    }

    @RequestMapping(path = "/addition")
    public String addAnotherAdmin() {
        return "add-admin";
    }
}
