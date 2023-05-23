package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.models.UpiRegistrationResponse;

public interface UpiService {
    UpiRegistrationResponse register(Long accountNumber);
    UpiRegistrationResponse activate(String upiId);
}
