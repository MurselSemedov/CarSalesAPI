package com.mursalsamad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dealer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dealer extends BaseEntity{

    private String firstName;
    private String lastName;
    @OneToOne
    private Address address;
}
