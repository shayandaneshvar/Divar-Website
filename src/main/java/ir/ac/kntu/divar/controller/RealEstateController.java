package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.service.advertisement.realestate.CommercialSellService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.RealEstateService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialRentService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialSellService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{city}/real-estate")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RealEstateController {
    private final CommercialSellService commercialSellService;
    private final RealEstateService realEstateService;
    private final ResidentialSellService residentialSellService;
    private final ResidentialRentService residentialRentService;

    @GetMapping("/buy-residential")
    public String buyResidential(@PathVariable String city, Model model) {
        model.addAttribute("ads", residentialSellService.getAllByCity(city));
        model.addAttribute("cat", "فروش مسکونی");
        return "sub-real-estate";
    }
}
