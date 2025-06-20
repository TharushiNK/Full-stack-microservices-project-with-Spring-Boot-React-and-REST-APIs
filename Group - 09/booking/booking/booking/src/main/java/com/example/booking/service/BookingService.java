package com.example.booking.service;


import com.example.booking.entity.Booking;
import com.example.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public  Booking getBookingById(int id)
    {
        Optional<Booking> stu =
                bookingRepository.findById(id);

        if (stu.isPresent()){
            return  stu.get();
        }
        return null;
    }
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    //Call the repository method
    public List<Booking> searchByStatus (String status) {
        return bookingRepository.searchByStatus( status);
    }




}



