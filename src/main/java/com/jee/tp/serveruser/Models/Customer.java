package com.jee.tp.serveruser.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString//(exclude = {"Name"})
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NonNull
    private String Name;
    @NonNull
    //@Temporal(TemporalType.DATE) //if the field is of Date type
    private LocalDate BirthDay;

    @OneToMany(mappedBy = "liker", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<customerLikes> ToysLiked=new HashSet<>();



    public Customer(@NonNull String name, @NonNull LocalDate birthDay) {
        Name = name;
        BirthDay = birthDay;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Name.equals(customer.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", BirthDay=" + BirthDay +

                '}';
    }
}
