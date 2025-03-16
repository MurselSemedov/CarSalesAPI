package com.mursalsamad.dao.entity;

import com.mursalsamad.model.enums.CarStatusType;
import com.mursalsamad.model.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    private String licencePlate;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    @Enumerated(STRING)
    private CurrencyType currencyType;
    private BigDecimal damagePrice;
    @Enumerated(STRING)
    private CarStatusType carStatus;
}
