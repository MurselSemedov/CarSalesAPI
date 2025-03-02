package com.mursalsamad.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarOutputDTO {

    private String licencePlate;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    private String currencyType;
    private BigDecimal damagePrice;
    private String carStatusType;
}
