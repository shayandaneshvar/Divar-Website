package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialSellService;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/new")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NewAdsController {
    public static final String UPLOAD_DIRECTORY = "./src/main" +
            "/resources/static/pictures";
    private final ResidentialSellService residentialSellService;

    @GetMapping()
    public String getNewAdvertisement() {
        return "new-start";
    }

    @GetMapping("/buy-residential")
    public String newResidentialSell(Model model) {
        model.addAttribute("rs", new NewResidentialSellDTO());
        return "newBuyResidential";
    }

    @PostMapping("/buy-residential")
    public String newResidentialSellSubmit(NewResidentialSellDTO input,
                                           @RequestParam("uploadedImage")
                                                   MultipartFile file)
            throws IOException {
        String fileName = null;
        if (file != null) {
            fileName = "/" + (int) Math.abs(Math.random() * 10000000) +
                    file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIRECTORY, fileName);
            Files.write(path, file.getBytes());
        }
        residentialSellService.create(input, fileName);
        return "redirect:/";
    }
}
