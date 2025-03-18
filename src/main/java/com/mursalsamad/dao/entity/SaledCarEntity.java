package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "saled_cars")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaledCarEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private DealerEntity dealer;

    @ToString.Exclude
    @OneToOne(fetch = LAZY,cascade = {PERSIST,MERGE})
    @JoinColumn(referencedColumnName = "id",unique = true)
    private CarEntity car;

    @ToString.Exclude
    @ManyToOne(fetch = LAZY)
    private CustomerEntity customer;
}
