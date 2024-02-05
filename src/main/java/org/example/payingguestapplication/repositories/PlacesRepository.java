package org.example.payingguestapplication.repositories;

import org.example.payingguestapplication.models.Places;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Places, Integer> {

}