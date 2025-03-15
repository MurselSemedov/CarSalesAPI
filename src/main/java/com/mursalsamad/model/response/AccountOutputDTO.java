package com.mursalsamad.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOutputDTO {

    private String cartNumber;
    private BigDecimal amount;
    private String currencyType;
    private Date createDate;
}
