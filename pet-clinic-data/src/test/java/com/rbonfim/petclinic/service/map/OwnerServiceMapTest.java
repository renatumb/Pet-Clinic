package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    final Long ownerId = 15L;
    final String lastName = "Smith";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner found = ownerServiceMap.findByLastName(lastName);
        assertNotNull(found);
        assertEquals(lastName, found.getLastName());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        assertEquals(ownerId, ownerServiceMap.findById(ownerId).getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        assertEquals(id, ownerServiceMap.save(Owner.builder().id(id).build()).getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }
    
    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerServiceMap.findByLastName("foo");
        assertNull(smith);
    }
}