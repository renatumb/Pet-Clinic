package com.rbonfim.petclinic.repositories;

import com.rbonfim.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRespository extends CrudRepository<Visit, Long> {
}
