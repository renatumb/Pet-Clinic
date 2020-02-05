package com.rbonfim.petclinic.controllers;

import com.rbonfim.petclinic.model.Pet;
import com.rbonfim.petclinic.model.Visit;
import com.rbonfim.petclinic.service.PetService;
import com.rbonfim.petclinic.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadWithVisit(@PathVariable Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        visit.setPet(pet);
        pet.getVisits().add(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initVisitForm(@PathVariable Long petId, Map<String, Object> model) {

        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/*/pets/{petId}/visits/new")
    public String processVisitForm(@Valid Visit visit, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "pets/createOrUpdateVisitForm";


        visitService.save(visit);

        return "redirect:/owners/" + visit.getPet().getOwner().getId();
    }


}
