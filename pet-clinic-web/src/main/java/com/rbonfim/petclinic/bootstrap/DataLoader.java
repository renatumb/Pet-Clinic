package com.rbonfim.petclinic.bootstrap;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.model.Vet;
import com.rbonfim.petclinic.service.OwnerService;
import com.rbonfim.petclinic.service.VetService;
import com.rbonfim.petclinic.service.map.OwnerServiceMap;
import com.rbonfim.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("FirstNameOO1");
        o1.setLastName("LastNameOO1");

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("FirsNameOO2");
        o2.setLastName("LastNameOO2");

        ownerService.save(o1);
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setId(3L);
        v1.setFirstName("VetOO1First");
        v1.setLastName("Vet002Last");

        Vet v2 = new Vet();
        v2.setId(4L);
        v2.setFirstName("Vet002First");
        v2.setLastName("Vet002Last");

        vetService.save(v1);
        vetService.save(v2);
    }
}
