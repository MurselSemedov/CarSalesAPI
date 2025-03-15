package com.mursalsamad.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saled_car" , uniqueConstraints = @UniqueConstraint(
        columnNames = {"car_id"},name = "uq_dealer_car_customer"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaledCarEntity extends BaseEntity{

    @ManyToOne
    private DealerEntity dealerEntity;
    @ManyToOne
    private CarEntity carEntity;
    @ManyToOne
    private CustomerEntity customerEntity;
}
