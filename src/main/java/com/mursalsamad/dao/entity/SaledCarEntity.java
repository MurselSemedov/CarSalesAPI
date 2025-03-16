package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "saled_car" , uniqueConstraints = @UniqueConstraint(
        columnNames = {"car_id"},name = "uq_dealer_car_customer"))
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaledCarEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    @ManyToOne
    private DealerEntity dealerEntity;
    @ManyToOne
    private CarEntity carEntity;
    @ManyToOne
    private CustomerEntity customerEntity;
}
