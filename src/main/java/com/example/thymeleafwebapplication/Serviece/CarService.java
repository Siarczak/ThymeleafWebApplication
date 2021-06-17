package com.example.thymeleafwebapplication.Serviece;

import com.example.thymeleafwebapplication.Model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(long id);

    boolean modifiedCar(Car car);

    boolean removedCar(long id);

    boolean addedCar(Car car);


}
