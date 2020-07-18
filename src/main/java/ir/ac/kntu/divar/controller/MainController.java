package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainController {
    private final LocationService service;

    @GetMapping(value = {"/","index","index.html"})
    public String getIndex(Model model) {
        model.addAttribute("cities", service.getAllCities());
        return "index";
    }

}
