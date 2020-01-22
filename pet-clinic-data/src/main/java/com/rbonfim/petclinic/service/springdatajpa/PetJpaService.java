package com.rbonfim.petclinic.service.springdatajpa;

import com.rbonfim.petclinic.model.Pet;
import com.rbonfim.petclinic.repositories.PetRepository;
import com.rbonfim.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    public final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet obj) {
        return petRepository.save(obj);
    }

    @Override
    public void delete(Pet o) {
        petRepository.delete(o);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
