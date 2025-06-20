package com.example.bookings.service;


import com.example.bookings.entity.Booking;
import com.example.bookings.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;
    //create a new booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    //get booking details
    public List<Booking> getBookingList() {
        return bookingRepository.findAll();
    }


    //Query based
    //update booking status by id
    public Booking updateBookingStatusById(int id, Booking booking) {
        return bookingRepository.updateBookingStatusById(id,booking);
    }



}