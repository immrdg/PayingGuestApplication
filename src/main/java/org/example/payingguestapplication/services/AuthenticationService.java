package org.example.payingguestapplication.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isAuthenticated(HttpServletRequest request,String role){
        HttpSession session=request.getSession(false);
        if(session==null){
            System.out.println("session is null");
            return false;
        }
        else{
            String sRole= (String) session.getAttribute("role");
            String username = (String) session.getAttribute("name");
            System.out.println(sRole+";;;"+username);
            if(username==null || sRole==null)
                return false;
            return sRole.equals(role);
        }
    }

}
