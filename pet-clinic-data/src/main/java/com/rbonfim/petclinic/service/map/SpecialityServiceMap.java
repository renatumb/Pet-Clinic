package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.Speciality;
import com.rbonfim.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }

    @Override
    public void delete(Speciality o) {
        super.delete(o);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
