package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.GeneralFilterDTO;
import ir.ac.kntu.divar.model.service.advertisement.electronics.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/{city}/electronics")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ElectronicsController {
    private final ElectronicsService electronicsService;
    private final ConsoleService consoleService;
    private final PCService pcService;
    private final MobileService mobileService;
    private final LaptopService laptopService;

    @GetMapping("/laptops")
    public String getLaptops(@PathVariable String city, Model model) {
        model.addAttribute("ads", laptopService.getAllByCity(city));
        model.addAttribute("cat", "لپتاپ");
        model.addAttribute("city", city);
        model.addAttribute("address", "laptops");
        model.addAttribute("dto", new GeneralFilterDTO());
        return "sub-electronics";
    }

    @PostMapping("/laptops")
    public String filterGetLaptops(@PathVariable String city, Model model,
                                @ModelAttribute GeneralFilterDTO dto) {
        model.addAttribute("ads", laptopService.filter(city, dto));
        model.addAttribute("cat", "لپتاپ");
        model.addAttribute("city", city);
        model.addAttribute("address", "laptops");
        model.addAttribute("dto", dto);
        return "sub-electronics";
    }

    @GetMapping("/pc")
    public String getPCs(@PathVariable String city, Model model) {
        model.addAttribute("ads", pcService.getAllByCity(city));
        model.addAttribute("cat", "کامپیوتر رومیزی");
        model.addAttribute("city", city);
        model.addAttribute("address", "pc");
        model.addAttribute("dto", new GeneralFilterDTO());
        return "sub-electronics";
    }

    @PostMapping("/pc")
    public String filterGetPCs(@PathVariable String city, Model model,
                                @ModelAttribute GeneralFilterDTO dto) {
        model.addAttribute("ads", pcService.filter(city, dto));
        model.addAttribute("cat", "کامپیوتر رومیزی");
        model.addAttribute("city", city);
        model.addAttribute("address", "pc");
        model.addAttribute("dto", dto);
        return "sub-electronics";
    }

    @GetMapping("/mobiles")
    public String getMobiles(@PathVariable String city, Model model) {
        model.addAttribute("ads", mobileService.getAllByCity(city));
        model.addAttribute("cat", "موبایل");
        model.addAttribute("city", city);
        model.addAttribute("address", "mobiles");
        model.addAttribute("dto", new GeneralFilterDTO());
        return "sub-electronics";
    }

    @PostMapping("/mobiles")
    public String filterGetMobiles(@PathVariable String city, Model model,
                                @ModelAttribute GeneralFilterDTO dto) {
        model.addAttribute("ads", mobileService.filter(city, dto));
        model.addAttribute("cat", "موبایل");
        model.addAttribute("city", city);
        model.addAttribute("address", "mobiles");
        model.addAttribute("dto", dto);
        return "sub-electronics";
    }

    @GetMapping("/consoles")
    public String getConsoles(@PathVariable String city, Model model) {
        model.addAttribute("ads", consoleService.getAllByCity(city));
        model.addAttribute("cat", "کنسول بازی");
        model.addAttribute("city", city);
        model.addAttribute("address", "consoles");
        model.addAttribute("dto", new GeneralFilterDTO());
        return "sub-electronics";
    }

    @PostMapping("/consoles")
    public String filterGetConsoles(@PathVariable String city, Model model,
                                   @ModelAttribute GeneralFilterDTO dto) {
        model.addAttribute("ads", consoleService.filter(city, dto));
        model.addAttribute("cat", "کنسول بازی");
        model.addAttribute("city", city);
        model.addAttribute("address", "consoles");
        model.addAttribute("dto", dto);
        return "sub-electronics";
    }
    @GetMapping()
    public String getElectronics(@PathVariable String city, Model model) {
        model.addAttribute("ads", electronicsService.getAllByCity(city));
        model.addAttribute("city", city);
        model.addAttribute("dto", new GeneralFilterDTO());
        return "electronics";
    }

    @PostMapping()
    public String filterGetElectronics(@PathVariable String city, Model model,
                                    @ModelAttribute GeneralFilterDTO dto) {
        model.addAttribute("ads", electronicsService.filter(city, dto));
        model.addAttribute("city", city);
        model.addAttribute("dto", dto);
        return "electronics";
    }

}
