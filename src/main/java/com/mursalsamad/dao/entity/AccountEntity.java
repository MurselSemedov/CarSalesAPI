package com.mursalsamad.dao.entity;

import com.mursalsamad.model.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }

    private String cartNumber;
    private BigDecimal amount;
    @Enumerated(STRING)
    private CurrencyType currencyType;


}
