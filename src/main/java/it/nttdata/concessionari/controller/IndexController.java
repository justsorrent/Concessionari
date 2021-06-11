package it.nttdata.concessionari.controller;

import it.nttdata.concessionari.repositories.DealershipRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final DealershipRepository dealershipRepository;

    public IndexController(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("numRegion", dealershipRepository.countRegion());
        return "index";
    }
}
