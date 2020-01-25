package com.rbonfim.petclinic.service.springdatajpa;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.repositories.OwnerRepository;
import com.rbonfim.petclinic.repositories.PetRepository;
import com.rbonfim.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String SMITHE = "Smithe";
    public static final long ID = 10L;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().lastName(SMITHE).id(ID).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        assertEquals(SMITHE, ownerJpaService.findByLastName(SMITHE).getLastName());
    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();

        owners.add(Owner.builder().build());
        owners.add(Owner.builder().build());
        owners.add(Owner.builder().build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set o = (Set) ownerRepository.findAll();

        assertEquals(3, o.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(ID)).thenReturn(Optional.of(owner));
        assertNotNull(ownerJpaService.findById(ID));
        assertEquals(owner, ownerJpaService.findById(ID));
    }

    @Test
    void save() {
        when(ownerRepository.save(owner)).thenReturn(owner);
        assertEquals(owner, ownerRepository.save(owner));
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerJpaService.deleteById(10L);
        verify(ownerRepository).deleteById(anyLong());
    }
}