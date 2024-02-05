package org.example.payingguestapplication.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.payingguestapplication.exceptions.UnauthorizedAccessException;
import org.example.payingguestapplication.models.Tenant;
import org.example.payingguestapplication.services.AuthenticationService;
import org.example.payingguestapplication.services.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value = "/pg")
public class PgController {


    private final AuthenticationService authenticationService;
    private final TenantService tenantService;

    public PgController(AuthenticationService authenticationService, TenantService tenantService) {
        this.authenticationService = authenticationService;
        this.tenantService = tenantService;

    }

    @GetMapping("login")
    public String login(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        if(authenticationService.isAuthenticated(request,"pg")){
            response.sendRedirect("/places");
        }
        return "loginTenant";
    }

    @PostMapping("login")
    public void registerForm(@RequestParam String email,@RequestParam String password, Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
        Tenant tenant = tenantService.getTenant(email,password);
        if(tenant == null)
        {
            model.addAttribute("error", "Invalid Credentials");
            response.sendRedirect("/pg/login");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("role","pg");
            session.setAttribute("email",tenant.getEmail());
            session.setAttribute("name",tenant.getName());
        }

        response.sendRedirect("/pg/places");

    }


    @GetMapping("register")
    public String register(){
        return "registerTenant";
    }

    @PostMapping("register")
    public String loginForm(@ModelAttribute Tenant tenant){
        System.out.println(tenantService.saveTenant(tenant));
        return "loginTenant";
    }

    @GetMapping("places")
    public String getPlaces(HttpServletRequest request)  {
       if(!authenticationService.isAuthenticated(request,"pg"))
           throw new UnauthorizedAccessException("You must be logged in");

       return "places";
    }



}
