package com.example.thymeleafwebapplication.Serviece;

import com.example.thymeleafwebapplication.Model.Car;
import com.example.thymeleafwebapplication.Model.CarList;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean modifiedCar( Car car) {
        Optional<Car> carToModify = getCarById(car.getId());
        if(carToModify.isPresent())
        {
            carList.getCars().remove(carToModify.get());
            Car modifiedCar = new Car(car.getBrand(),car.getModel());


            return carList.getCars().add(modifiedCar);


        }
        else
            return false;
    }

    @Override
    public boolean removedCar(long id) {

        Optional<Car> carToRemove = getCarById(id);
        return carToRemove.map(car -> carList.getCars().remove(car))
                .orElse(false);

//       Optional<Car> carToRemove = carList.getCars()
//               .stream()
//               .filter(car -> car.getId() == id)
//               .findFirst();

//       if(carToRemove.isPresent())
//       {
////             carList.getCars().remove(carToRemove);
////           carList.getCars().remove((int)carToRemove.get().getId());
//           System.out.println( carList.getCars().remove((int)carToRemove.get().getId()));
//
//           return true;
//       }
//       else
//       {
//
//           return false;
//       }
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
}
