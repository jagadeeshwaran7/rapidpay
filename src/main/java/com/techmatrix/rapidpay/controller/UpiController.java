package com.techmatrix.rapidpay.controller;

import com.techmatrix.rapidpay.models.UpiRegistrationResponse;
import com.techmatrix.rapidpay.service.UpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("upi")
@RequiredArgsConstructor
public class UpiController {
    @Autowired
    private final UpiService upiService;
    // @GetMapping("/{id}/")
    //    @ResponseBody
    //    public Long registerUpi(@PathParam("id") Long id){
    //
    //        return id;
    //    }

    @GetMapping("/{id}/")
    @RequestMapping(method = RequestMethod.PUT)
    public UpiRegistrationResponse registerUpi(@RequestParam(name = "id", required = false) Long id){

        return upiService.register(id);
    }
}