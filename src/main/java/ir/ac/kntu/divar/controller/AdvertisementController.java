package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.exceptions.NotFoundException;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.service.UserService;
import ir.ac.kntu.divar.model.service.advertisement.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ads")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementController {
    private final AdvertisementService advertisementService;
    private final UserService userService;

    @GetMapping("/{city}")
    public String getAds(@PathVariable String city, Model model) {
        model.addAttribute("ads", advertisementService.getAllByCity(city));
        model.addAttribute("city", city);
        return "all-ads";
    }

    @GetMapping({"/a/{id}"})
    public String getAdvertisement(@PathVariable String id, Model model) {
        AdvertisementDTO dto;
        String marked = "نشان کردن";
        try {
            dto = advertisementService.apply(Long.valueOf(id));
            if (userService.isMarked(id)) {
                marked = "نشان شده";
            }
            Advertisement ad = advertisementService.findById(id);
            userService.handleCurrentUserRecentAds(ad);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Not Found!");
        }
        model.addAttribute("dto", dto);
        model.addAttribute("id", id);
        model.addAttribute("mark", marked);
        return "post";
    }

    @RequestMapping({"/{id}/mark"})
    public String handleMarkingAdvertisement(@PathVariable String id) {
        Advertisement ad = advertisementService.findById(id);
        if (null != ad) {
            userService.handleCurrentUserMarkedAds(ad);
            return ("redirect:/ads/a/" + id);
        }
        return "redirect:/";
    }

    @GetMapping({"/real-estate/{id}", "/vehicles/{id}", "/electronics/{id}"})
    public String getAdvertisement(@PathVariable String id) {
        return ("forward:/ads/a/" + id);
    }
}
