package org.example.payingguestapplication.repositories;

import org.example.payingguestapplication.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findByEmailAndPassword(String email,String password);
}