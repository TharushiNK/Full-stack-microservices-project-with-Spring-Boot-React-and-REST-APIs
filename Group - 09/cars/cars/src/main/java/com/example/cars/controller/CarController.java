package com.example.cars.controller;


import com.example.cars.entity.Car;
import com.example.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class CarController {
    //declare a variable referencing the CarService class
    @Autowired
    public CarService carService;

    //Get method to get all the data of cars
    @GetMapping(path = "cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    //Post method to add new car
    @PostMapping(path = "cars")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }

    //Get method to read car by their id
    @GetMapping(path = "cars/{id}")
    public Car getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    //Delete method to delete car by their id
    @DeleteMapping(path = "cars/{id}")
    public void deleteCarById(@PathVariable int id){
        carService.deleteCarById(id);
    }

    //Update car details
    @PutMapping(path = "cars/{id}")
    public Car updateCar(@PathVariable int id,@RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    //-------Query based REST END points for searching and filtering--------//
    //Get car list by brand
    @GetMapping(path = "cars", params = "brand")
    public List<Car> searchCarByBrand(@RequestParam String brand){
        return carService.searchCarByBrand(brand);
    }

    //Get car list by model
    @GetMapping(path = "cars", params = "model")
    public List<Car> searchCarByModel(@RequestParam String model){
        return carService.searchCarByModel(model);
    }

    //Get car list by availability
    @GetMapping(path = "cars", params = "availability")
    public List<Car> searchCarByAvailability(@RequestParam boolean availability){
        return carService.searchCarByAvailability(availability);
    }

    //Get car list by price
    @GetMapping(path = "cars", params = "price")
    public List<Car> searchCarByPrice(@RequestParam double price){
        return carService.searchCarByPrice(price);
    }







}

