package com.mursalsamad.dao.entity;

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
public class DealerEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    @OneToOne
    private AddressEntity addressEntity;
}
