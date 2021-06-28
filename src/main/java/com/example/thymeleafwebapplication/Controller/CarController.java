package com.example.thymeleafwebapplication.Controller;

import com.example.thymeleafwebapplication.Model.Car;
import com.example.thymeleafwebapplication.Serviece.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CarController {

    CarServiceImp carService;


    @Autowired
    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public String getCar(Model model) {
        model.addAttribute("cars", carService.getCars());
        model.addAttribute("newCar", new Car());
        return "car";
    }


    @GetMapping("/car/{id}")
    public String getCarById(@PathVariable long id, Model model) {
        Optional<Car> carById = carService.getCarById(id);

        if (carById.isPresent()) {
            model.addAttribute("car", carById.get());
            return "updatecar";
        } else {
            return "redirect:/error";
        }
    }


    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {


        car.setId(carService.setIdToAdd());
        carService.addedCar(car);

        return "redirect:/car";


    }


    @PostMapping("/updatecar")
    public String modifyCar(@ModelAttribute Car carToModify) {

        System.out.println(carService.modifiedCar(carToModify));
        if (carService.modifiedCar(carToModify)) {


            return "redirect:/car";
        }

        return "redirect:/error";
    }


    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable long id) {


        if (carService.removedCar(id)) {


            return "redirect:/car";
        } else {

            return "redirect:/error";
        }
    }
}
