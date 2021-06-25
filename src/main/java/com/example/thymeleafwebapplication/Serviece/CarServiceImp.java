package com.example.thymeleafwebapplication.Serviece;

import com.example.thymeleafwebapplication.Model.Car;
import com.example.thymeleafwebapplication.Model.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService{

    CarList carList;

    CarServiceImp()
    {


    }
@Autowired
    public CarServiceImp(CarList carList) {
        this.carList = carList;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareListOfCars(){

        carList.getCars();

    }

    @Override
    public List<Car> getCars() {
        return carList.getCars();
    }

    @Override
    public Optional<Car> getCarById(long id) {

        return carList.getCars()
                .stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }

    @Override
    public boolean addedCar(Car car) {
        boolean addCar = carList.getCars().add(car);

        if(addCar)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    public boolean modifiedCar(Car car) {
        Optional<Car> isCarPresent = getCarById(car.getId());
        if (isCarPresent.isPresent()) {
            carList.getCars().remove(isCarPresent.get());
            Car updatedCar = new Car(car.getBrand(), car.getModel());
            updatedCar.setId(isCarPresent.get().getId());
            return carList.getCars().add(updatedCar);
        }
        return false;
    }

    @Override
    public boolean removedCar(long id) {


        Optional<Car> carToRemove = getCarById(id);

        return carToRemove.map(car -> carList.getCars().remove(car)).orElse(false);

    }
    }

