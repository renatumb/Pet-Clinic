package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.Vet;
import com.rbonfim.petclinic.service.SpecialityService;
import com.rbonfim.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if( obj.getSpecialities().size() > 0 ){
            obj.getSpecialities().forEach( speciality -> {
                if( speciality.getId() == null ){
                    speciality.setId(specialityService.save(speciality).getId() );
                }
            });
        }
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
