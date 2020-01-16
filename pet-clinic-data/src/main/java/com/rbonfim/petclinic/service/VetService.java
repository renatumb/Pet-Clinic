package com.rbonfim.petclinic.service;

import com.rbonfim.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet x);

    Set<Vet> findAll();
}
