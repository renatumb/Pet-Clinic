package com.rbonfim.petclinic.bootstrap;

import com.rbonfim.petclinic.model.*;
import com.rbonfim.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        lodaData();
    }

    private void lodaData() {
        PetType petType001 = new PetType();
        petType001.setName("Dog");
        petTypeService.save(petType001);

        PetType petType002 = new PetType();
        petType002.setName("Cat");
        petTypeService.save(petType002);

        Owner o1 = new Owner();
        o1.setFirstName("FirstNameOO1");
        o1.setLastName("LastNameOO1");
        o1.setAddress("owner001 address 001");
        o1.setTelephone("owner001 phone");
        o1.setCity("owner001 city");

        Pet p1 = new Pet();
        p1.setPetType(petType001);
        p1.setName("pet001");
        p1.setDob(LocalDate.now() );
        p1.setOwner(o1);
        o1.getPetSet().add(p1);




        Owner o2 = new Owner();
        o2.setFirstName("FirsNameOO2");
        o2.setLastName("LastNameOO2");
        o2.setAddress("owner002 address 002");
        o2.setTelephone("owner002 phone");
        o2.setCity("owner002 city");

        ownerService.save(o1);
        ownerService.save(o2);

        Speciality sp001 = new Speciality();
        sp001.setDescription("sp001");
        specialityService.save(sp001);

        Speciality sp002 = new Speciality();
        sp002.setDescription("sp002");
        specialityService.save(sp002);

        Speciality sp003 = new Speciality();
        sp003.setDescription("sp003");
        specialityService.save(sp003);


        Speciality sp004 = new Speciality();
        sp004.setDescription("sp004");
        specialityService.save(sp004);

        Speciality sp005 = new Speciality();
        sp005.setDescription("sp005");
        specialityService.save(sp005);

        Speciality sp006 = new Speciality();
        sp006.setDescription("sp006");
        specialityService.save(sp006);

        Vet v1 = new Vet();
        v1.setFirstName("Vet001First");
        v1.setLastName("Vet001Last");
        v1.getSpecialities().add(sp001);
        v1.getSpecialities().add(sp003);

        Vet v2 = new Vet();
        v2.setFirstName("Vet002First");
        v2.setLastName("Vet002Last");
        v2.getSpecialities().add(sp002);

        v2.getSpecialities().add(sp004);
        v2.getSpecialities().add(sp005);
        v2.getSpecialities().add(sp006);

        vetService.save(v1);
        vetService.save(v2);

        Visit visit = new Visit();
        visit.setDescription("description visit 001");
        visit.setLocalDate( LocalDate.now() );
        visit.setPet( p1);
        visitService.save(visit);
    }
}
