package com.techmatrix.rapidpay.database.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "upi")
@Getter
@Setter
@RequiredArgsConstructor
public class UpiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "upi_id")
    private String upiId;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "upi_secret")
    private String upiSecret;
    @Column(name = "upi_status")
    private String upiStatus;
}
