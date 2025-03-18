package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dealers")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DealerEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    private String firstName;
    private String lastName;
    @ManyToOne(
            fetch = LAZY,
            cascade = {PERSIST,MERGE}
    )
    @ToString.Exclude
    private AddressEntity addressEntity;

    @ToString.Exclude
    @OneToMany(
            mappedBy = "id",
            cascade = {PERSIST,MERGE}
    )
    private List<CarEntity> cars;
}
