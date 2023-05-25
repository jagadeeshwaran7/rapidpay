package com.techmatrix.rapidpay.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpiActivationRequest {
    private String upiId;
    private String secret;
}
