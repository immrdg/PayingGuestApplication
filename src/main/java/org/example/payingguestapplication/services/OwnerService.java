package org.example.payingguestapplication.services;

import org.example.payingguestapplication.models.Owner;
import org.example.payingguestapplication.models.Tenant;

public interface OwnerService {
    Owner getOwner(String email, String password);

    Owner saveOwner(Owner owner);
}
