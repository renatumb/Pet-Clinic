package com.rbonfim.petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn( name = "owner_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn( name = "type_id")
    private PetType petType;
    @Column(name="name")
    private String name;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
