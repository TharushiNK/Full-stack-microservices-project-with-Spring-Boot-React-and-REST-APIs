package com.example.booking.controller;


import com.example.booking.entity.Booking;
import com.example.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @GetMapping(path = "bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }


    @PostMapping(path = "/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping(path = "/bookings")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.ok("Bookings with ID " + id + " has been deleted.");
    }

    @GetMapping(path = "/bookings", params = "status")
    public List<Booking> searchByStatus(@RequestParam(defaultValue = "pending") String status) {
        if (!status.equals("pending") && !status.equals("complete")) {
            throw new IllegalArgumentException("Invalid status. Use 'pending' or 'complete'.");
        }

        return bookingService.searchByStatus(status);
    }


}






