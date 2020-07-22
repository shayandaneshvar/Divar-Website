package ir.ac.kntu.divar.model.service.advertisement;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.service.advertisement.electronics.ElectronicsService;
import ir.ac.kntu.divar.model.service.advertisement.realestate.RealEstateService;
import ir.ac.kntu.divar.model.service.advertisement.vehicle.VehicleService;
import ir.ac.kntu.divar.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdvertisementService implements Handler {
    private final ElectronicsService electronicsService;
    private final VehicleService vehicleService;
    private final RealEstateService realEstateService;

    @Loggable
    public List<? extends Advertisement> getAllByCity(String city) {
        List<Advertisement> list =
                new ArrayList<>(electronicsService.getAllByCity(city));
        list.addAll(vehicleService.getAllByCity(city));
        list.addAll(realEstateService.getAllByCity(city));
        return list;
    }


    @Override
    public AdvertisementDTO apply(Long aLong) {
        List<Handler> handlers = Arrays.asList(electronicsService,
                vehicleService, realEstateService);
        return handlers.stream().map(z -> {
            AdvertisementDTO res;
            try {
                res = z.apply(aLong);
            } catch (Exception ignored) {
                res = null;
            }
            return res;
        }).filter(Objects::nonNull).findFirst().orElse(null);
    }

    @Loggable
    public Advertisement findById(String s) {
        Long id = Long.valueOf(s);
        Advertisement ad = electronicsService.findById(id);
        if (ad == null) {
            ad = realEstateService.findById(id);
        }
        if (ad == null) {
            ad = vehicleService.findById(id);
        }
        return ad;
    }
}
