package com.example.thymeleafwebapplication.Model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarList {

    private static List<Car> cars;




    CarList()
    {


        Car car1 = new Car( "Romero","Alfa");
        Car car2 = new Car( "Volkswagen","Golf");
        Car car3 = new Car( "Skoda","Octavian");
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

}


