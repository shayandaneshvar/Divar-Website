package ir.ac.kntu.divar.model.service.advertisement;

import ir.ac.kntu.divar.controller.VehicleController;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.service.advertisement.electronics.ElectronicsService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.RealEstateService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementService {
    private final ElectronicsService electronicsService;
    private final VehicleService vehicleService;
    private final RealEstateService realEstateService;
    public List<? extends Advertisement> getAllByCity(String city) {
        List<Advertisement> list =
                new ArrayList<>(electronicsService.getAllByCity(city));
        list.addAll(vehicleService.getAllByCity(city));
        list.addAll(realEstateService.getAllByCity(city));
        return list;
    }
}
