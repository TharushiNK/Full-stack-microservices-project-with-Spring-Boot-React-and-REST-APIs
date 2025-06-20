package com.example.test_twenty_one.controller;

import com.example.test_twenty_one.entity.Booking;
import com.example.test_twenty_one.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @GetMapping(path = "bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }
}
