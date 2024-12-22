package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        return "accessDenied";
    }
}
