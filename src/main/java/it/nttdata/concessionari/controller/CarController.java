package it.nttdata.concessionari.controller;

import it.nttdata.concessionari.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "cars";
    }
}
