package com.example.cars.service;

import com.example.cars.entity.Car;
import com.example.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    //declare variable referencing to the CarRepository interface
    @Autowired
    public CarRepository carRepository;

    //method to get all the data from the car table
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    //Add new car
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    //Get car by ID
    public Car getCarById(int id) {
        Optional<Car> car1 = carRepository.findById(id);
        if (car1.isPresent()) {
            return car1.get();
        }
        return null;
    }

    //Delete car by ID
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

    //Fully update the car by id
    public Car updateCar(int id, Car car) {
        Optional<Car> car1 = carRepository.findById(id);

        if (car1.isPresent()) {
            Car existingCar = car1.get();
            existingCar.setBrand(car.getBrand());
            existingCar.setModel(car.getModel());
            existingCar.setPrice(car.getPrice());
            existingCar.setAvailability(car.getAvailability());
            carRepository.save(existingCar);
            return existingCar;
        }
        return car;
    }
    //Search car by brand
    public List<Car> searchCarByBrand(String brand){
        return carRepository.searchCarByBrand(brand);
    }

    //Search car by model
    public List<Car> searchCarByModel(String model){
        return carRepository.searchCarByModel(model);
    }

    //Search car by availability
    public List<Car> searchCarByAvailability(boolean availability){
        return carRepository.searchCarByAvailability(availability);
    }

    //Search car by price
    public List<Car> searchCarByPrice(double price){
        return carRepository.searchCarByPrice(price);
    }
}

