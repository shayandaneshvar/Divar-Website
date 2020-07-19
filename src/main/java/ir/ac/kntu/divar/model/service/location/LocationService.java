package ir.ac.kntu.divar.model.service.location;

import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.location.CityRepository;
import ir.ac.kntu.divar.model.repo.location.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LocationService {
    private final CityRepository cityRepository;
    private final ZoneRepository zoneRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Zone> getZones(City city) {
        return zoneRepository.findByCity(city);
    }

}
