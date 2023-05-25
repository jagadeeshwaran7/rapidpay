package com.techmatrix.rapidpay.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public class SendMoney {
    private  Integer sendingAmount;
    private  String senderUpiId;
    private  String receiverUpiId;
    private  String passcode;
}
