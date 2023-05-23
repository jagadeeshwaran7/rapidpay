package com.techmatrix.rapidpay.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Upi {
    private String upiId;
    private Long accountNumber;
    private Integer upiSecret;
    private String upiStatus;
}
