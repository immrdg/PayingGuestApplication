package org.example.payingguestapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping({"/home", "/"})
    public String home(Model model,HttpServletRequest request,@RequestParam(required = false) String error){
        model.addAttribute("title", "Home");
        model.addAttribute("time",Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        if(error != null){
            model.addAttribute("error", error);
        }
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("page","Register");
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("page","Login");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session!=null)
            session.invalidate();
        return "redirect:/home";
    }

}
