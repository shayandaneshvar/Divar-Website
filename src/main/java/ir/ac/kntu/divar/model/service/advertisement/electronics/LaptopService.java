package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.dto.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Laptop;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.LaptopRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LaptopService {
    private final LaptopRepository repository;
    private final LocationService locationService;

    public List<Laptop> getAll() {
        return repository.findAll();
    }

    public List<Laptop> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Laptop> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Laptop> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Laptop>) ElectronicsService.filterUtil(result, dto);
    }
}
