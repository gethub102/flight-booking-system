package main.java.com.offer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminAuthController {

    public String adminLogin() {
        return "/admin/login";
    }
}
