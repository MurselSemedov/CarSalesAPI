package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    private String city; //Baku
    private String district; //Surakhani
    private String village; //Hovsan
    private String street; //Ibish Mammadov kuchesi

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }
}
