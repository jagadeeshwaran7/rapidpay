package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.database.entities.AccountEntity;
import com.techmatrix.rapidpay.database.entities.UpiEntity;
import com.techmatrix.rapidpay.database.repo.AccountRepo;
import com.techmatrix.rapidpay.database.repo.UpiRepo;
import com.techmatrix.rapidpay.models.SendMoney;
import com.techmatrix.rapidpay.models.UpiActivationRequest;
import com.techmatrix.rapidpay.models.UpiRegistrationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpiServiceImpl implements UpiService {
    private final UpiRepo upiRepo;
    private final AccountRepo accountRepo;

    @Override
    public UpiRegistrationResponse register(Long accountNumber) {
        String upiId = UUID.randomUUID().toString();
        UpiEntity upiEntity = new UpiEntity();
        upiEntity.setUpiId(upiId);
        upiEntity.setUpiStatus("Registered");
        upiEntity.setAccountNumber(accountNumber);
        upiRepo.save(upiEntity);

        UpiRegistrationResponse upiRegistrationResponse = new UpiRegistrationResponse();
        upiRegistrationResponse.setUpiId(upiId);
        upiRegistrationResponse.setMessage("UPI Registered Successfully");
        return upiRegistrationResponse;
    }

    @Override
    public UpiRegistrationResponse activate(UpiActivationRequest upiActivationRequest) {
        if (upiActivationRequest == null || StringUtils.isEmpty(upiActivationRequest.getUpiId())) {
            return null;
        }
        UpiEntity upiEntity = upiRepo.getUpiEntityByUpiId(upiActivationRequest.getUpiId());
        if (upiEntity == null) {
            return null;
        }
        upiEntity.setUpiStatus("UPI Activated");
        upiEntity.setUpiSecret(upiActivationRequest.getSecret());
        upiRepo.save(upiEntity);
        UpiRegistrationResponse upiRegistrationResponse = new UpiRegistrationResponse();
        upiRegistrationResponse.setUpiId(upiActivationRequest.getUpiId());
        upiRegistrationResponse.setMessage("Upi Activated");
        return upiRegistrationResponse;
    }


    @Override
    public UpiRegistrationResponse changePasscode(String password) {
        return null;
    }

    @Override
    public String sendMoneyTo(SendMoney sendMoney) {

        UpiEntity sender = upiRepo.getUpiEntityByUpiId(sendMoney.getSenderUpiId());
        UpiEntity receiver = upiRepo.getUpiEntityByUpiId(sendMoney.getReceiverUpiId());
        if (sender == null) {
            throw new RuntimeException("Invlid sender UPI Id");
        } else if (receiver == null) {
            throw new RuntimeException("Invlid receiver UPI Id");
        }
        AccountEntity senderAccount = accountRepo.getAccountEntityByAccountNumber(sender.getAccountNumber());
        AccountEntity receiverAccount = accountRepo.getAccountEntityByAccountNumber(receiver.getAccountNumber());

        if (transactionValidator(sender, receiver, sendMoney, senderAccount.getAmount())) {
            senderAccount.setAmount(senderAccount.getAmount() - sendMoney.getSendingAmount());
            receiverAccount.setAmount(receiverAccount.getAmount() + sendMoney.getSendingAmount());

            accountRepo.save(senderAccount);
            accountRepo.save(receiverAccount);
            return "Payment Successful";
        }
        return "Payment Failed";
    }

    public Boolean transactionValidator(UpiEntity sender, UpiEntity receiver, SendMoney sendmoney, Long senderAccountBalance) {
         if (sendmoney.getSendingAmount() == null || sendmoney.getSendingAmount() <= 0) {
            throw new RuntimeException("Invalid Transaction Amount");
        } else if( !(sender.getUpiStatus().equals("UPI Activated") && receiver.getUpiStatus().equals("UPI Activated")))  {
            throw new RuntimeException("Either sender or receiver UPI is not activate");

        } else if (!(sender.getUpiSecret().equals(sendmoney.getPasscode()))) {
            throw new RuntimeException("Invalid Password");
        } else if (senderAccountBalance < sendmoney.getSendingAmount()) {
            throw new RuntimeException("Insufficient Balance");
        }
        return Boolean.TRUE;
    }
}
