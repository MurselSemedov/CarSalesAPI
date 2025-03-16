package com.mursalsamad.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountOutputDTO {

    private String cartNumber;
    private BigDecimal amount;
    private String currencyType;
    private LocalDate createDate;
}
