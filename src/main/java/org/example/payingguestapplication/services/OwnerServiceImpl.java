package org.example.payingguestapplication.services;

import org.example.payingguestapplication.models.Owner;
import org.example.payingguestapplication.models.Tenant;
import org.example.payingguestapplication.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner getOwner(String email, String password) {
        return ownerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
}
