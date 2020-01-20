package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.PetType;
import com.rbonfim.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType obj) {
        return super.save(obj);
    }

    @Override
    public void delete(PetType o) {
        super.delete(o);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
