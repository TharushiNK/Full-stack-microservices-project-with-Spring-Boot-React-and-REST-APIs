package com.example.payments.controller;


import com.example.payments.entity.Payment;
import com.example.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @PostMapping(path = "/payments")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }
    //Get payment details by Payment id
    @GetMapping(path = "payments/{id}")
    public  Payment getPaymentById(@PathVariable int id){
        return paymentService.getPaymentById(id);
    }
    // Get all payments by User ID
    @GetMapping(path = "payments/user/{user_id}")
    public List<Payment> getPaymentsByUserId(@PathVariable int user_id) {
        return paymentService.getPaymentsByUserId(user_id);
    }

}
