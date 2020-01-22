package com.rbonfim.petclinic.repositories;

import com.rbonfim.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
