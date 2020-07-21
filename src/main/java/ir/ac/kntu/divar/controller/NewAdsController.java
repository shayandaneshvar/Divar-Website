package ir.ac.kntu.divar.controller;

import ir.ac.kntu.divar.model.dto.NewVehicleDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewElectronicsDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewLaptopDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewMobileDTO;
import ir.ac.kntu.divar.model.dto.realestate.NewCommercialSellDTO;
import ir.ac.kntu.divar.model.dto.realestate.NewResidentialRentDTO;
import ir.ac.kntu.divar.model.dto.realestate.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.service.advertisement.electronics.ConsoleService;
import ir.ac.kntu.divar.model.service.advertisement.electronics.LaptopService;
import ir.ac.kntu.divar.model.service.advertisement.electronics.MobileService;
import ir.ac.kntu.divar.model.service.advertisement.electronics.PCService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.CommercialSellService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialRentService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.ResidentialSellService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.CarService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.TruckService;
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
    private final CarService carService;
    private final TruckService truckService;
    private final LaptopService laptopService;
    private final MobileService mobileService;
    private final PCService pcService;
    private final ConsoleService consoleService;

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

    @GetMapping("/buy-commercial")
    public String newCommercialSellSubmit(Model model) {
        model.addAttribute("rs", new NewCommercialSellDTO());
        return "NewBuyCommercial";
    }

    @GetMapping("/car")
    public String newCar(Model model) {
        model.addAttribute("rs", new NewVehicleDTO());
        model.addAttribute("address", "car");
        return "NewVehicle";
    }

    @PostMapping("/car")
    public String newCarSubmit(NewVehicleDTO input,
                               @RequestParam("uploadedImage")
                                       MultipartFile file) throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        carService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/truck")
    public String newTruckSubmit(NewVehicleDTO input,
                                 @RequestParam("uploadedImage")
                                         MultipartFile file) throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        truckService.create(input, fileName);
        return "redirect:/";
    }

    @GetMapping("/truck")
    public String newTruck(Model model) {
        model.addAttribute("rs", new NewVehicleDTO());
        model.addAttribute("address", "truck");
        return "NewVehicle";
    }

    @GetMapping("/laptop")
    public String newLaptop(Model model) {
        model.addAttribute("rs", new NewLaptopDTO());
        return "NewLaptop";
    }

    @GetMapping("/mobile")
    public String newMobile(Model model) {
        model.addAttribute("rs", new NewMobileDTO());
        return "NewMobile";
    }

    @GetMapping("/pc")
    public String newPC(Model model) {
        model.addAttribute("rs", new NewElectronicsDTO());
        model.addAttribute("address", "pc");
        return "NewElectronic";
    }

    @GetMapping("/console")
    public String newConsole(Model model) {
        model.addAttribute("rs", new NewElectronicsDTO());
        model.addAttribute("address", "console");
        return "NewElectronic";
    }

    @PostMapping("/pc")
    public String newPCSubmit(NewElectronicsDTO input,
                              @RequestParam("uploadedImage")
                                      MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        pcService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/console")
    public String newConsoleSubmit(NewElectronicsDTO input,
                                   @RequestParam("uploadedImage")
                                           MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        consoleService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/mobile")
    public String newMobileSubmit(NewMobileDTO input,
                                  @RequestParam("uploadedImage")
                                          MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        mobileService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/laptop")
    public String newLaptopSubmit(NewLaptopDTO input,
                                  @RequestParam("uploadedImage")
                                          MultipartFile file)
            throws IOException {
        String fileName = UploadUtil.handleUpload(file);
        laptopService.create(input, fileName);
        return "redirect:/";
    }

    @PostMapping("/buy-commercial")
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
