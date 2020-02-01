package com.rbonfim.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> petSet = new HashSet<>();

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    public Set<Pet> getPetSet() {
        return petSet;
    }

    @Builder
    public Owner(Long id, String firstName, String lastName, Set<Pet> petSet, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if (petSet != null) {
            this.petSet = petSet;
        }
    }

    public Pet getPet(String name, boolean ignoreView) {

        if (petSet.size() > 0) {
            for (Pet p : petSet) {
                if (p.getName().toLowerCase().equals(name.toLowerCase())) {
                    return p;
                }
            }
        }
        return null;
    }
}
