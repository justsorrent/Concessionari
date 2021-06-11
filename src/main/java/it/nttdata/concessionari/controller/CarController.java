package it.nttdata.concessionari.controller;

import it.nttdata.concessionari.model.Car;
import it.nttdata.concessionari.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "cars";
    }

    @GetMapping("/cars/{dealershipId}")
    public String getCarsByDealership(@PathVariable Long dealershipId, Model model) {

        ArrayList<Car> allCars = (ArrayList<Car>) carRepository.findAll();
        Set<Car> ans = allCars.stream()
                .filter(c -> c.getDealership().getId().equals(dealershipId))
                .collect(Collectors.toSet());

        model.addAttribute("cars", ans);

        return "cars";
    }

}
