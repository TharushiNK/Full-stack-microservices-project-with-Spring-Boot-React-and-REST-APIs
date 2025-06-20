package com.example.bookings.repository;

import com.example.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    //JPQL query to update booking status

    @Query("select b from Booking b where b.id =?1")
    public Booking updateBookingStatusById(int id, Booking booking);


}
