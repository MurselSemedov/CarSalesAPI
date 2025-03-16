package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
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
