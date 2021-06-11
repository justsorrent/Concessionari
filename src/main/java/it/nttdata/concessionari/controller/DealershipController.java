package it.nttdata.concessionari.controller;

import it.nttdata.concessionari.repositories.DealershipRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DealershipController {

    private final DealershipRepository dealershipRepository;

    public DealershipController(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    @GetMapping("/dealerships")
    public String getDealerships(Model model) {
        model.addAttribute("dealerList", dealershipRepository.findAll());
        return "dealerships";
    }
}
