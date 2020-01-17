package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.Vet;
import com.rbonfim.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long o) {
        return super.findById(o);
    }

    @Override
    public Vet save(Vet obj) {
        return super.save(obj);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
