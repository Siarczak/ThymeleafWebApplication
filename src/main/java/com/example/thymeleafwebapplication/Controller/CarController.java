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
    Car car;

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
        Optional<Car> optionalCar = carService.getCarById(id);

        if(optionalCar.isPresent()){
            model.addAttribute("car", optionalCar.get());
            return "updatecar";
        } else {
            return "redirect:/error";
        }
    }




    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        car.setId(carService.getCars().size() + 1);
        carService.getCars().add(car);

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

    //        System.out.println(carServiceImp.getCars());
//        carServiceImp.removedCar(carToDelete.getId());
//        System.out.println( carServiceImp.removedCar(carToDelete.getId()));
//        System.out.println(carServiceImp.getCars());

//            System.out.println(carServiceImp.getCars());
//            System.out.println( carServiceImp.getCars().get((int)id));
//            System.out.println(carServiceImp.getCars());




//    @RequestMapping(value = "/carbyid.html/{id}", method =RequestMethod.GET)
//    public String getCarByID(@PathVariable String examId) {
//
//        return "editExam";
//    }
}


    //
//    @PostMapping ("/carbyid/{id}")
//    public String findCarByID(@PathVariable long id,Model model) {
//        Optional<Car> carById = carList.getCarByid(id);
//        if (carById.isPresent()) {
//
//            model.addAttribute("carById",carById.get());
//            return "carbyid";
//        } else {
//            return "error";
//
//        }
//    }



//    @PostMapping("/delete/{id}")
//    public String removeCar(@PathVariable long id) {
//        if (carList.isDeleted(id)) {
//            return "redirect:/car";
//        }
//
//        return "redirect:/error";
//    }


//    @GetMapping("/updatecar")
//    public String getCar1(Model model)
//    {
//        model.addAttribute("cars",carList.getCars());
//        model.addAttribute("newCar",new Car());
//        model.addAttribute("updateCar",new Car());
//        return "car";
//    }

//    @PostMapping("/add-car")
//    public String addCar(@ModelAttribute Car car)
//    {
//
//        car.setId(carList.getCars().size()+1);
//        carList.getCars().add(car);
//
//
//        return "redirect:/car";
//
//    }

//    @GetMapping ("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//
//        model.addAttribute("carById", carList.getCars().get((int)id) );
//        return "update-car";
//    }

//    @DeleteMapping("/car/{id}")
//    @ResponseBody
//    public String deleteCar(@PathVariable int id)
//        {
//
//            carList.deleteCar(id);
//            return "redirect:/car";
//
//        }







//    @PostMapping("/delete/{id}")
//    public String removeCar(@PathVariable long id) {
//        if (carList.isDeleted(id)) {
//            return "redirect:/car";
//        }
//
//        return "redirect:/error";
//    }


