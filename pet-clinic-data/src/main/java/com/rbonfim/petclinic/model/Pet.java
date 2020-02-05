package com.rbonfim.petclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn( name = "owner_id")
    private Owner owner;

    @Column(name = "dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn( name = "type_id")
    private PetType petType;
    @Column(name="name")
    private String name;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit>  visits = new HashSet<>();

    @Builder
    public Pet(Long id, Owner owner, LocalDate dob, PetType petType, String name, Set<Visit> visits) {
        super(id);
        this.owner = owner;
        this.dob = dob;
        this.petType = petType;
        this.name = name;

        if (visits == null || visits.size() == 0) this.visits = visits;
    }
}
