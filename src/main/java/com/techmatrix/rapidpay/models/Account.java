package com.techmatrix.rapidpay.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Long accountNumber;
    private String accountHolder;
    private Long mobileNumber;
}
