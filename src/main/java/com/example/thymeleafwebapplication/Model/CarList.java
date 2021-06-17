package com.example.thymeleafwebapplication.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarList {

    private static List<Car> cars;

    CarList()
    {


        Car car1 = new Car("Romero","Alfa");
        Car car2 = new Car("Volkswagen","Golf");
        Car car3 = new Car("Skoda","Octavian");
        Car car4 = new Car("BMW","3");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);


    }

    public List<Car> getCars() {
        return cars;
    }





//    public Optional<Car> getCarByid(long id)
//    {
//        return cars.stream()
//                .filter(car -> car.getId() == id)
//                .findFirst();
//
//
//    }
//
//    public Optional<Car> getCarByidSearch(long id)
//    {
//        return cars.stream()
//                .filter(car -> car.getId() == id)
//                .findFirst();
//
//
//    }
//
//    public boolean isDeleted(long id)
//    {
//        Optional<Car> carToDelete = getCarByid(id);
//
//        return carToDelete.map(car -> cars.remove(car)).orElse(false);
//
//
//    }
//
//


//    public Optional<Car> getCarById(long id) {
//        return cars.stream()
//                .filter(car -> car.getId() == id)
//                .findFirst();
//    }
//
//    public boolean isRemovedCar(long id) {
//        Optional<Car> optionalCar = getCarById(id) ;
//        return optionalCar.map(car -> cars.remove(car))
//                .orElse(false);
//    }
}


