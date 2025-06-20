package com.example.bookings.service;


import com.example.bookings.entity.Booking;
import com.example.bookings.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


    public Booking updateBookingStatusById(int id, Booking booking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);

        if (existingBooking.isPresent()) {
            Booking updatedBooking = existingBooking.get();
            updatedBooking.setStatus(booking.getStatus()); // Only update the status
            bookingRepository.save(updatedBooking);
            return updatedBooking;
        }
        return booking; // Return the input booking if not found
    }


    //Delete car by ID
    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookingsByCarId(int car_id) {
        return bookingRepository.findBookingByCarId(car_id);
    }



}