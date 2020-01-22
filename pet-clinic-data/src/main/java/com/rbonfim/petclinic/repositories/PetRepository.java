package com.rbonfim.petclinic.repositories;


import com.rbonfim.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
