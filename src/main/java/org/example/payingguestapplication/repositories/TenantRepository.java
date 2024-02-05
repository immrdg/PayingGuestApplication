package org.example.payingguestapplication.repositories;

import org.example.payingguestapplication.models.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    Tenant findByEmailAndPassword(String email,String password);
}