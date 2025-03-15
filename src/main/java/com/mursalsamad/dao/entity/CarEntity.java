package com.mursalsamad.dao.entity;

import com.mursalsamad.model.enums.CarStatusType;
import com.mursalsamad.model.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity extends BaseEntity{

    private String licencePlate;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    private BigDecimal damagePrice;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}
