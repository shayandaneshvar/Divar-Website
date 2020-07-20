package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.dto.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Laptop;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Mobile;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.MobileRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MobileService {
    private final MobileRepository repository;
    private final LocationService locationService;
    public List<Mobile> getAll() {
        return repository.findAll();
    }

    public List<Mobile> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Mobile> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Mobile> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Mobile>) ElectronicsService.filterUtil(result, dto);
    }
}
