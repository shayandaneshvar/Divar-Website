package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.VehicleFilterDTO;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/{city}/vehicles")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VehicleController {
    private final CarService carService;

    @GetMapping("/cars")
    public String getCars(@PathVariable String city, Model model) {
        model.addAttribute("ads", carService.getAllByCity(city));
        model.addAttribute("cat", "خودروی سواری");
        model.addAttribute("city", city);
        model.addAttribute("address", "cars");
        model.addAttribute("dto", new VehicleFilterDTO());
        return "sub-vehicle";
    }

    @PostMapping("/cars")
    public String filterGetCars(@PathVariable String city, Model model,
                                @ModelAttribute VehicleFilterDTO dto) {
        model.addAttribute("ads", carService.filter(city,dto));
        model.addAttribute("cat", "خودروی سواری");
        model.addAttribute("city", city);
        model.addAttribute("address", "cars");
        model.addAttribute("dto", dto);
        return "sub-vehicle";
    }

}
