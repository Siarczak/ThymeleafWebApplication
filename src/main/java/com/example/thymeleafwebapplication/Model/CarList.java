package com.example.thymeleafwebapplication.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarList {

    private static List<Car> cars;
    private int counter;


    CarList() {


        Car car1 = new Car("Romero", "Alfa");
        Car car2 = new Car("Wieswagen", "Golf");
        Car car3 = new Car("Szkoda", "Octavian");
        Car car4 = new Car("BedzieszMialWydatki", "3");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        counter = cars.size();


    }

    public List<Car> getCars() {
        return cars;
    }

    public int idForAddMethod() {
        return counter++;

    }


}


