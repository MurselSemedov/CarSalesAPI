package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dealer_car" , uniqueConstraints = @UniqueConstraint(
        columnNames = {"car_id"},name = "uq_dealer_car"))
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealerCar{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    @ManyToOne
    private DealerEntity dealerEntity;
    @OneToOne
    private CarEntity carEntity;

}
