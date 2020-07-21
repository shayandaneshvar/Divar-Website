package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.filters.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.service.advertisement.realestate.CommercialSellService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.RealEstateService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialRentService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialSellService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ads/{city}/real-estate")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RealEstateController {
    private final CommercialSellService commercialSellService;
    private final RealEstateService realEstateService;
    private final ResidentialSellService residentialSellService;
    private final ResidentialRentService residentialRentService;

    @GetMapping()
    public String realEstate(@PathVariable String city, Model model){
        model.addAttribute("ads", realEstateService.getAllByCity(city));
        model.addAttribute("city", city);
        RealEstateFilterDTO dto = new RealEstateFilterDTO();
        model.addAttribute("dto", dto);
        return "real-estate";
    }

    @GetMapping("/buy-residential")
    public String buyResidential(@PathVariable String city, Model model) {
        model.addAttribute("ads", residentialSellService.getAllByCity(city));
        model.addAttribute("cat", "فروش مسکونی");
        model.addAttribute("city", city);
        RealEstateFilterDTO dto = new RealEstateFilterDTO();
        model.addAttribute("address","buy-residential");
        model.addAttribute("dto", dto);
        return "sub-real-estate";
    }

    @GetMapping("/rent-residential")
    public String rentResidential(@PathVariable String city,Model model){
        model.addAttribute("ads", residentialRentService.getAllByCity(city));
        model.addAttribute("cat", "اجاره مسکونی");
        model.addAttribute("city", city);
        model.addAttribute("address","rent-residential");
        RealEstateFilterDTO dto = new RealEstateFilterDTO();
        model.addAttribute("dto", dto);
        return "sub-real-estate-rent";
    }

    @GetMapping("/buy-commercial")
    public String buyCommercial(@PathVariable String city, Model model) {
        model.addAttribute("ads", commercialSellService.getAllByCity(city));
        model.addAttribute("cat", "فروش تجاری");
        model.addAttribute("city", city);
        RealEstateFilterDTO dto = new RealEstateFilterDTO();
        model.addAttribute("address","buy-commercial");
        model.addAttribute("dto", dto);
        return "sub-real-estate";
    }

    @PostMapping("/buy-commercial")
    public String filterBuyCommercial(@PathVariable String city,
                                       @ModelAttribute RealEstateFilterDTO dto,
                                       Model model) {
        model.addAttribute("cat", "فروش تجاری");
        model.addAttribute("city", city);
        model.addAttribute("ads", commercialSellService.filter(city,dto));
        model.addAttribute("address","buy-commercial");
        model.addAttribute("dto", dto);
        return "sub-real-estate";
    }

    @PostMapping("/rent-residential")
    public String filterRentResidential(@PathVariable String city,
                                       @ModelAttribute RealEstateFilterDTO dto,
                                       Model model) {
        model.addAttribute("cat", "اجاره مسکونی");
        model.addAttribute("city", city);
        model.addAttribute("ads", residentialRentService.filter(city,dto));
        model.addAttribute("dto", dto);
        model.addAttribute("address","rent-residential");
        return "sub-real-estate-rent";
    }

    @PostMapping("/buy-residential")
    public String filterBuyResidential(@PathVariable String city,
                                       @ModelAttribute RealEstateFilterDTO dto,
                                       Model model) {
        model.addAttribute("cat", "فروش مسکونی");
        model.addAttribute("city", city);
        model.addAttribute("ads", residentialSellService.filter(city,dto));
        model.addAttribute("address","buy-residential");
        model.addAttribute("dto", dto);
        return "sub-real-estate";
    }

    @PostMapping()
    public String filterRealEstate(@PathVariable String city,
                                   @ModelAttribute RealEstateFilterDTO dto,
                                   Model model){
        model.addAttribute("city", city);
        model.addAttribute("ads", realEstateService.filter(city,dto));
        model.addAttribute("dto", dto);
        return "sub-real-estate";
    }
}
