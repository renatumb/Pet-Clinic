package com.rbonfim.petclinic.controllers;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.model.Pet;
import com.rbonfim.petclinic.model.PetType;
import com.rbonfim.petclinic.service.OwnerService;
import com.rbonfim.petclinic.service.PetService;
import com.rbonfim.petclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("owners/{ownerID}")
public class PetController {

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetType() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerID") Long ownerID) {
        return ownerService.findById(ownerID);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    // --------------------------------------------------------------------------------------------------------------- //
    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = Pet.builder().build();
        owner.getPetSet().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult bindingResult, ModelMap modelMap) {

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            bindingResult.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPetSet().add(pet);
        pet.setOwner(owner);
        /*
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }*/

        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/pets/{petID}/edit")
    public String initUpdateForm(@PathVariable Long petID, Model model) {
        model.addAttribute("pet", petService.findById(petID));
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petID}/edit")
    public String processUpdateForm(Owner owner, @Valid Pet pet, BindingResult bindingResult, ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            pet.setOwner(owner);
            modelMap.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }

        owner.getPetSet().add(pet);
        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }
}
