package com.rbonfim.petclinic.service.map;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.service.OwnerService;
import com.rbonfim.petclinic.service.PetService;
import com.rbonfim.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long o) {
        return super.findById(o);
    }

    @Override
    public Owner save(Owner obj) {

        if (obj != null) {
            if (obj.getPetSet() != null) {

                obj.getPetSet().forEach(pet -> {

                            if (pet.getPetType() == null) {
                                throw new RuntimeException("Pet Type is required");
                            }
                            if (pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }

                            if (pet.getId() == null) {
                                petService.save(pet).setId(pet.getId());
                            }
                        }
                );
            }
            return super.save(obj);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
