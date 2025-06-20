package com.example.bookings.controller;


import com.example.bookings.entity.Booking;
import com.example.bookings.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @PostMapping(path = "bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping(path = "bookings")
    public List<Booking> getBookingList(){  //get all the bookings as a list
        return bookingService.getBookingList();
    }
    @PatchMapping(path = "bookings/{id}")
    public Booking updateBookingStatusById(@PathVariable int id,@RequestBody Booking booking){
        return bookingService.updateBookingStatusById(id,booking);

    }

}
