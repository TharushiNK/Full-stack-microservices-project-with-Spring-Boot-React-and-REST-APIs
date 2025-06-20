package com.example.payments.repository;


import com.example.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    //JPQL for Payment list by user id
    @Query("select p from Payment p where p.user_id =?1")
    public List<Payment> findByUserId(int id);
}
