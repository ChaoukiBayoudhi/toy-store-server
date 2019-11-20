package com.jee.tp.serveruser.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Provider_Address")
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "provider_city")
    private String city;
    private Long streetNumber;
    private String postalCode;


    @OneToOne(mappedBy = "address")
    private toyProvider toyprovider;

    public Address(String city, Long streetNumber, String postalCode, toyProvider toyprovider) {
        this.city = city;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.toyprovider = toyprovider;
    }
}
