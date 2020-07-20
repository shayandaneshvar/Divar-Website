package ir.ac.kntu.divar.model.service.advertisement.vehicle;

import ir.ac.kntu.divar.model.dto.VehicleFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.VehicleAdvertisement;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VehicleService {
    private final LocationService locationService;
    private final CarService carService;
    private final TruckService truckService;

    public static List<? extends VehicleAdvertisement> filterUtil(List<? extends
            VehicleAdvertisement> result, VehicleFilterDTO dto) {
        if (dto.getOnSale() != dto.getRequested()) {
            Advertisement.Type filter;
            if (dto.getOnSale()) {
                filter = Advertisement.Type.ON_SALE;
            } else {
                filter = Advertisement.Type.REQUESTED;
            }
            result = result.stream().filter(z -> z.getAdType().equals(filter))
                    .collect(Collectors.toList());
        }
        if (dto.getMaxPrice() != null) {
            result = result.stream().filter(z ->
                    z.getPrice() <= dto.getMaxPrice())
                    .collect(Collectors.toList());
        }
        if (dto.getMinPrice() != null) {
            result = result.stream().filter(z ->
                    z.getPrice() >= dto.getMinPrice())
                    .collect(Collectors.toList());
        }
        if (dto.getRemoveExchange() != dto.getExchangeOnly()) {
            boolean filter;
            if (dto.getRemoveExchange()) {
                filter = false;
            } else {
                filter = true;
            }
            result = result.stream().filter(z -> z.getExchange().equals(filter))
                    .collect(Collectors.toList());
        }

        if (dto.getRemoveNegotiation()) {
            result = result.stream().filter(z -> z.getPrice() != -2.0)
                    .collect(Collectors.toList());
        }
        if (dto.getUrgentOnly()) {
            result = result.stream().filter(Advertisement::getUrgent)
                    .collect(Collectors.toList());
        }
        if (dto.getWithImageOnly()) {
            result = result.stream().filter(Advertisement::getHasImage)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<? extends VehicleAdvertisement> getAllByCity(String input) {
        List<VehicleAdvertisement> list =
                new ArrayList<>(truckService.getAllByCity(input));
        list.addAll(carService.getAllByCity(input));
        return list;
    }

    public List<? extends VehicleAdvertisement> filter(String input,
                                                       VehicleFilterDTO dto) {
        List<VehicleAdvertisement> list =
                new ArrayList<>(truckService.filter(input, dto));
        list.addAll(carService.filter(input, dto));
        return list;
    }
}
