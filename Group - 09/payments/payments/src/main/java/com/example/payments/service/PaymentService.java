package com.example.payments.service;


import com.example.payments.entity.Payment;
import com.example.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    public PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int id){
        Optional<Payment> payment1 =  paymentRepository.findById(id);
        if (payment1.isPresent()){
            return payment1.get();
        }
        return null;
    }

    public List<Payment> getPaymentsByUserId(int userId) {
        return paymentRepository.findByUserId(userId);
    }


}
