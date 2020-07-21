package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.exceptions.ComingSoonException;
import ir.ac.kntu.divar.model.service.UserService;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MainController {
    private final LocationService locationService;
    private final UserService userService;
    @GetMapping(value = {"/", "index", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("cities", locationService.getAllCities().stream()
                .distinct().collect(Collectors.toList()));
        return "index";
    }

    @GetMapping(value = "/support")
    public String getSupport() {
        throw new ComingSoonException();
    }

    @GetMapping(value = "/contact")
    public String contactUs() {
        return "contact";
    }

    @GetMapping("/login")
    public String showRegister(Model model) {
        model.addAttribute("mobile", new String());
        return "register";
    }

    @PostMapping("/login")
    public String register(@ModelAttribute String mobile) {
        userService.getUser(mobile);
        return "redirect:/";
    }
}