package com.jee.tp.serveruser.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "toy_provider")


public class toyProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany(mappedBy = "toyprovider", cascade = CascadeType.ALL)
    private Set<Toy> Toys = new HashSet<>();


    public toyProvider(@NonNull String name, Set<Toy> toys) {
        this.name = name;
        Toys = toys;
    }

    public toyProvider(@NonNull String name, Address address, Set<Toy> toys) {
        this.name = name;
        this.address = address;
        Toys = toys;
    }
}
