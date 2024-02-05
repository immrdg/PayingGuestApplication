package org.example.payingguestapplication.services;

import org.example.payingguestapplication.models.Tenant;
import org.springframework.stereotype.Service;


public interface TenantService {

    Tenant getTenant(String email,String password);

    Tenant saveTenant(Tenant tenant);


}
