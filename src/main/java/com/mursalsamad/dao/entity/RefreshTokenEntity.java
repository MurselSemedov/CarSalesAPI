package com.mursalsamad.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "refresh_tokens")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private LocalDate createDate;
    private String refreshToken;
    private LocalDate expireDate;
    @ManyToOne
    @ToString.Exclude
    private UserEntity userEntity;
}
