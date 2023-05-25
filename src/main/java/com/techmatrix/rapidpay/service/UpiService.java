package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.models.SendMoney;
import com.techmatrix.rapidpay.models.UpiActivationRequest;
import com.techmatrix.rapidpay.models.UpiRegistrationResponse;

public interface UpiService {
    UpiRegistrationResponse register(Long accountNumber);

    UpiRegistrationResponse activate(UpiActivationRequest upiActivationRequest);

    UpiRegistrationResponse changePasscode(String password);

    String sendMoneyTo(SendMoney sendMoney);
}
