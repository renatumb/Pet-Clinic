package com.rbonfim.petclinic.repositories;

import com.rbonfim.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRespository extends CrudRepository<Vet, Long> {
}
