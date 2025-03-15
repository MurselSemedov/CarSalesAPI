package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dealer_car" , uniqueConstraints = @UniqueConstraint(
        columnNames = {"car_id"},name = "uq_dealer_car"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealerCar extends BaseEntity{

    @ManyToOne
    private DealerEntity dealerEntity;
    @OneToOne
    private CarEntity carEntity;

}
