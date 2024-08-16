package com.bangez.tx.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "points")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;

    private int point;

    private String lastChargeDate;

    private Long userId;

}
