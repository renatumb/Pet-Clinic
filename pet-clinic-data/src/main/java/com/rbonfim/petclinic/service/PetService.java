package com.rbonfim.petclinic.service;

import com.rbonfim.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet x);

    Set<Pet> findAll();
}
