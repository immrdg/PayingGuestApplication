package org.example.payingguestapplication.services;

import org.example.payingguestapplication.models.Tenant;
import org.example.payingguestapplication.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Tenant getTenant(String email, String password) {
        return tenantRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
