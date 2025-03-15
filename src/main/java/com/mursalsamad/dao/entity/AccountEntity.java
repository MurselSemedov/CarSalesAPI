package com.mursalsamad.dao.entity;

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
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends BaseEntity{

    private String cartNumber;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
}
