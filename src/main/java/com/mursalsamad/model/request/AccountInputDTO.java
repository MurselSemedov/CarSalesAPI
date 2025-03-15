package com.mursalsamad.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInputDTO {

    private String cartNumber;
    private BigDecimal amount;
    private String currencyType;
}
