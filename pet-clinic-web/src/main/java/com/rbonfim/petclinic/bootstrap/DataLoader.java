package com.rbonfim.petclinic.bootstrap;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.model.Vet;
import com.rbonfim.petclinic.service.OwnerService;
import com.rbonfim.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner o1 = new Owner();
        o1.setFirstName("FirstNameOO1");
        o1.setLastName("LastNameOO1");

        Owner o2 = new Owner();
        o2.setFirstName("FirsNameOO2");
        o2.setLastName("LastNameOO2");

        ownerService.save(o1);
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setFirstName("Vet001First");
        v1.setLastName("Vet001Last");

        Vet v2 = new Vet();
        v2.setFirstName("Vet002First");
        v2.setLastName("Vet002Last");

        vetService.save(v1);
        vetService.save(v2);
    }
}
