package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
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

    @ManyToOne(
            fetch = LAZY,
            cascade = {PERSIST,MERGE}
    )
    @ToString.Exclude
    private AddressEntity address;

    @OneToOne(
            fetch = LAZY,
            cascade = {PERSIST,MERGE},
            mappedBy = "customer"
    )
    @ToString.Exclude
    private AccountEntity account;
}
