package ir.ac.kntu.divar.model.service.advertisement.vehicle;

import ir.ac.kntu.divar.model.dto.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.vehicle.CarRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CarService {
    private final LocationService locationService;
    private final CarRepository repository;

    public List<Car> getAll() {
        return repository.findAll();
    }

    public List<Car> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Car> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Car> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Car>) VehicleService.filterUtil(result, dto);
    }
}
