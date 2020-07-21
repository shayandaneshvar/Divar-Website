package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.NewCommercialSellDTO;
import ir.ac.kntu.divar.model.dto.NewResidentialRentDTO;
import ir.ac.kntu.divar.model.dto.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.service.advertisement.realestate.CommercialSellService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialRentService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialSellService;
import ir.ac.kntu.divar.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/new")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NewAdsController {
    private final ResidentialSellService residentialSellService;
    private final ResidentialRentService residentialRentService;
    private final CommercialSellService commercialSellService;

    @GetMapping()
    public String getNewAdvertisement() {
        return "new-start";
    }

    @GetMapping("/buy-residential")
    public String newResidentialSell(Model model) {
        model.addAttribute("rs", new NewResidentialSellDTO());
        return "newBuyResidential";
    }

    @GetMapping("/rent-residential")
    public String newResidentialRent(Model model) {
        model.addAttribute("rs", new NewResidentialRentDTO());
        return "NewBuyCommercial";
    }

    @PostMapping("/buy-commercial")
    public String newCommercialSellSubmit(Model model) {
        model.addAttribute("rs", new NewCommercialSellDTO());
        return "NewBuyCommercial";
    }

    @GetMapping("/buy-commercial")
    public String newCommercialSell(NewCommercialSellDTO input,
                                    @RequestParam("uploadedImage")
                                            MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        commercialSellService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/rent-residential")
    public String newResidentialRentSubmit(NewResidentialRentDTO input,
                                           @RequestParam("uploadedImage")
                                                   MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        residentialRentService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/buy-residential")
    public String newResidentialSellSubmit(NewResidentialSellDTO input,
                                           @RequestParam("uploadedImage")
                                                   MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        residentialSellService.create(input, fileName);
        return "redirect:/";
    }
}
