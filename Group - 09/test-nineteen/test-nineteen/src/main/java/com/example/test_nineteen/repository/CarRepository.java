package com.example.test_nineteen.repository;

import com.example.test_nineteen.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {


    //JPQL for search car by brand
    @Query("select c from Car c where c.brand =?1")
    public List<Car> searchCarByBrand(String brand);

    //JPQL for search car by model
    @Query("select c from Car c where c.model =?1")
    public List<Car> searchCarByModel(String model);

    //JPQL for search car by availability
    @Query("select c from Car c where c.availability =?1")
    public List<Car> searchCarByAvailability(boolean availability);

    //JPQL for search car by price
    @Query("select c from Car c where c.price =?1")
    public List<Car> searchCarByPrice(double price);


}
