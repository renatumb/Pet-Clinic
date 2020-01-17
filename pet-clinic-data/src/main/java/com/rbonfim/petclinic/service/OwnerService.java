package com.rbonfim.petclinic.service;

import com.rbonfim.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
