package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dealer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealerEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    private String firstName;
    private String lastName;
    @OneToOne
    private AddressEntity addressEntity;
}
