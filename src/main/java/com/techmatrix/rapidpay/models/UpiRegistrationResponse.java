package com.techmatrix.rapidpay.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpiRegistrationResponse {
    private String upiId;
    private String message;
}
