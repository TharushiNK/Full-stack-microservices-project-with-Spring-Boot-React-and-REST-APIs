package com.example.bookings.repository;

import com.example.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    //JPQL query to update booking status



    //JPQL for get list of bookings for a car
    @Query("select b from Booking b where b.car_id =?1")
    public List<Booking> findBookingByCarId(int car_id);

}
