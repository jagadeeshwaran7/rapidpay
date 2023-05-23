package com.techmatrix.rapidpay.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "account_holder_name")
    private String accountHolder;
    @Column(name = "mobile_number")
    private Long mobileNumber;
}
