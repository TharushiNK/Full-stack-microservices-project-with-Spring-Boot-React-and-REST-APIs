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
    public Booking updateBookingStatusById(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBookingStatusById(id, booking);
    }
    //Delete method to delete booking by their id
    @DeleteMapping(path = "bookings/{id}")
    public void deleteBookingById(@PathVariable int id){
        bookingService.deleteBookingById(id);
    }

    // Get all Bookings by car ID
    @GetMapping(path = "bookings/cars/{car_id}")
    public List<Booking> getBookingsByCarId(@PathVariable int car_id) {
        return bookingService.getBookingsByCarId(car_id);
    }

}
