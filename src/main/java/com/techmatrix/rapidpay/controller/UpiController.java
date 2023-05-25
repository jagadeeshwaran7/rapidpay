package com.techmatrix.rapidpay.controller;

import com.techmatrix.rapidpay.models.SendMoney;
import com.techmatrix.rapidpay.models.UpiActivationRequest;
import com.techmatrix.rapidpay.models.UpiRegistrationResponse;
import com.techmatrix.rapidpay.service.UpiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("upi")
@RequiredArgsConstructor
@Slf4j
public class UpiController {
    @Autowired
    private final UpiService upiService;

    @PutMapping("/{id}/")
    public UpiRegistrationResponse registerUpi(@PathVariable(name = "id") Long id) {

        return upiService.register(id);
    }

    @PutMapping("/activate/")
    public UpiRegistrationResponse activate(@RequestBody UpiActivationRequest upiActivationRequest) {
        return upiService.activate(upiActivationRequest);
    }

    @PutMapping("/sendmoney/")
    public String sendMoney(@RequestBody SendMoney sendMoney) {
        try {
            return upiService.sendMoneyTo(sendMoney);
        } catch (RuntimeException exception) {
            return exception.getMessage();
        }
    }
}