package com.example.test_twenty_one.service;

import com.example.test_twenty_one.entity.Booking;
import com.example.test_twenty_one.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
}
