package ir.ac.kntu.divar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NewAdsController {

    @GetMapping()
    public String getNewAdvertisement(){
        return "new-start";
    }
}
