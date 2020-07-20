package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.VehicleFilterDTO;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.CarService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.TruckService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.VehicleService;
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
    private final TruckService truckService;
    private final VehicleService vehicleService;

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
        model.addAttribute("ads", carService.filter(city, dto));
        model.addAttribute("cat", "خودروی سواری");
        model.addAttribute("city", city);
        model.addAttribute("address", "cars");
        model.addAttribute("dto", dto);
        return "sub-vehicle";
    }

    @GetMapping("/trucks")
    public String getTrucks(@PathVariable String city, Model model) {
        model.addAttribute("ads", truckService.getAllByCity(city));
        model.addAttribute("cat", "خودروی سنگین");
        model.addAttribute("city", city);
        model.addAttribute("address", "trucks");
        model.addAttribute("dto", new VehicleFilterDTO());
        return "sub-vehicle";
    }

    @PostMapping("/trucks")
    public String filterGetTrucks(@PathVariable String city, Model model,
                                  @ModelAttribute VehicleFilterDTO dto) {
        model.addAttribute("ads", truckService.filter(city, dto));
        model.addAttribute("cat", "خودروی سنگین");
        model.addAttribute("city", city);
        model.addAttribute("address", "trucks");
        model.addAttribute("dto", dto);
        return "sub-vehicle";
    }

    @GetMapping()
    public String getVehicles(@PathVariable String city, Model model) {
        model.addAttribute("ads", vehicleService.getAllByCity(city));
        model.addAttribute("city", city);
        model.addAttribute("dto", new VehicleFilterDTO());
        return "vehicle";
    }

    @PostMapping()
    public String filterGetVehicles(@PathVariable String city, Model model,
                                    @ModelAttribute VehicleFilterDTO dto) {
        model.addAttribute("ads", vehicleService.filter(city, dto));
        model.addAttribute("city", city);
        model.addAttribute("dto", dto);
        return "vehicle";
    }
}
