package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.exceptions.ComingSoonException;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainController {
    private final LocationService service;

    @GetMapping(value = {"/", "index", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("cities", service.getAllCities().stream()
                .distinct().collect(Collectors.toList()));
        return "index";
    }

    @GetMapping(value = "/support")
    public String getSupport() {
        throw new ComingSoonException();
    }
}