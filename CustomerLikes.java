package com.jee.tp.serveruser.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data

@NoArgsConstructor
@Entity
@Table(name="Toys_liked_by_customer")
public class customerLikes implements Serializable {
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="toy",
//            joinColumns = {@JoinColumn(name="Id_Customer",referencedColumnName = "Id",
//                    nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name="code_toy",referencedColumnName = "code",nullable = false)})
//            /*We provide the name of the join table (course_like), and the foreign keys
//            with the @JoinColumn annotations.
//            The joinColumn attribute will connect to the owner side of the relationship,
//            and the inverseJoinColumn to the other side*/
//            /*Note, that using @JoinTable, or even @JoinColumn isn't required: JPA will generate the table and column names for us. However, the strategy JPA uses won't always match the naming conventions we use. Hence the possibility to configure table and column names.*/
//    Set<Toy> likedToyes;
//
//    @ManyToMany(mappedBy = "likedToyes")
//    Set<Customer> likers;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Toy toy;

    @Id
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Customer liker;

    public customerLikes(Customer liker) {
        this.liker = liker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        customerLikes that = (customerLikes) o;
        return toy.equals(that.toy) &&
                liker.equals(that.liker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toy, liker);
    }

    public void setToy(Toy toy) {
        this.toy=toy;
    }
    //    public customerLikes() {
//        likedToyes=new HashSet<>();
//        likers=new HashSet<>();
//    }
}

