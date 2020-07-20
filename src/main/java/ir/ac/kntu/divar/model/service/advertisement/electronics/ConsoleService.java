package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.dto.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Console;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.ConsoleRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConsoleService {
    private final LocationService locationService;
    private final ConsoleRepository repository;

    public List<Console> getAll() {
        return repository.findAll();
    }

    public List<Console> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Console> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Console> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Console>) ElectronicsService.filterUtil(result, dto);
    }
}
