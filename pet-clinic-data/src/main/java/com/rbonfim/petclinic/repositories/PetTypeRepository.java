package com.rbonfim.petclinic.repositories;

import com.rbonfim.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
