package org.example.payingguestapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.payingguestapplication.exceptions.UnauthorizedAccessException;
import org.example.payingguestapplication.models.Owner;
import org.example.payingguestapplication.models.Tenant;
import org.example.payingguestapplication.services.AuthenticationService;
import org.example.payingguestapplication.services.OwnerService;
import org.example.payingguestapplication.services.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    private final AuthenticationService authenticationService;
    private final OwnerService ownerService;

    public OwnerController(AuthenticationService authenticationService, OwnerService ownerService) {
        this.authenticationService = authenticationService;
        this.ownerService = ownerService;

    }

    @GetMapping("login")
    public String login(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        if(authenticationService.isAuthenticated(request,"pg")){
            response.sendRedirect("/places");
        }
        return "loginOwner";
    }

    @PostMapping("login")
    public void registerForm(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Owner owner = ownerService.getOwner(email,password);
        if(owner == null)
        {
            model.addAttribute("error", "Invalid Credentials");
            response.sendRedirect("/owner/login");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("role","pg");
            session.setAttribute("email",owner.getEmail());
            session.setAttribute("name",owner.getName());
        }

        response.sendRedirect("/owner/places");

    }


    @GetMapping("register")
    public String register(){
        return "registerTenant";
    }

    @PostMapping("register")
    public String loginForm(@ModelAttribute Owner owner){
        System.out.println(ownerService.saveOwner(owner));
        return "loginTenant";
    }

    @GetMapping("places")
    public String getPlaces(HttpServletRequest request)  {
        if(!authenticationService.isAuthenticated(request,"pg"))
            throw new UnauthorizedAccessException("You must be logged in");

        return "places";
    }


}
