package com.mursalsamad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String serialNumber;
    @Column(unique = true)
    private String finCode;
    @DateTimeFormat(pattern = "dd-mm-yyyy",iso = DateTimeFormat.ISO.DATE)
    @Column(columnDefinition = "DATETIME")
    private Date birthOfDate;
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;
}
