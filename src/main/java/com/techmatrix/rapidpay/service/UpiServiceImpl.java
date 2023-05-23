package com.techmatrix.rapidpay.service;

import com.techmatrix.rapidpay.database.entities.UpiEntity;
import com.techmatrix.rapidpay.database.repo.UpiRepo;
import com.techmatrix.rapidpay.models.UpiRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UpiServiceImpl implements UpiService{
    private final UpiRepo upiRepo;

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
    public UpiRegistrationResponse activate(String upiId) {
        return null;
    }
}
