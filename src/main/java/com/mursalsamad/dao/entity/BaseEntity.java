package com.mursalsamad.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;


@MappedSuperclass
@Data
@EqualsAndHashCode(of = "id")
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
}
