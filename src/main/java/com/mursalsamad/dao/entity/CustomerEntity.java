package com.mursalsamad.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true , callSuper = true)
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String serialNumber;
    @Column(unique = true)
    private String finCode;
    private LocalDate birthOfDate;
    @OneToOne
    private AddressEntity addressEntity;
    @OneToOne
    private AccountEntity accountEntity;
}
