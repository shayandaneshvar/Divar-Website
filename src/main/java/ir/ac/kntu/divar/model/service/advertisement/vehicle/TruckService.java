package ir.ac.kntu.divar.model.service.advertisement.vehicle;

import ir.ac.kntu.divar.model.dto.VehicleFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Truck;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.vehicle.TruckRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TruckService {
    private final LocationService locationService;
    private final TruckRepository repository;

    public List<Truck> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Truck> filter(String input, VehicleFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Truck> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Truck>) VehicleService.filterUtil(result, dto);
    }
}
