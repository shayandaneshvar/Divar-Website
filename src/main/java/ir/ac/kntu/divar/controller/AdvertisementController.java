package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.service.advertisement.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ads/{city}")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @GetMapping()
    public String getAds(@PathVariable String city, Model model) {
        model.addAttribute("ads", advertisementService.getAllByCity(city));
        model.addAttribute("city", city);
        return "all-ads";
    }
}
