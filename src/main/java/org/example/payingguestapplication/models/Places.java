package org.example.payingguestapplication.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Places {

    @Id
    private Integer id;

    private String name;

    private String address;

    private String city;

    private String country;

    private double rent;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne
    @ToString.Exclude
    @Cascade(value = CascadeType.DELETE_ORPHAN)
    private Owner owner;
}
