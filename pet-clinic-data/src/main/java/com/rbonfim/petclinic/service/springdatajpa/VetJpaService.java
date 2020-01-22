package com.rbonfim.petclinic.service.springdatajpa;

import com.rbonfim.petclinic.model.Vet;
import com.rbonfim.petclinic.repositories.VetRespository;
import com.rbonfim.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    VetRespository vetRespository;

    public VetJpaService(VetRespository vetRespository) {
        this.vetRespository = vetRespository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRespository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRespository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet obj) {
        return vetRespository.save(obj);
    }

    @Override
    public void delete(Vet o) {
        vetRespository.delete(o);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRespository.deleteById(aLong);
    }
}
