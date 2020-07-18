package ir.ac.kntu.divar.model.service;

import ir.ac.kntu.divar.model.entity.City;
import ir.ac.kntu.divar.model.entity.Zone;
import ir.ac.kntu.divar.model.repo.CityRepository;
import ir.ac.kntu.divar.model.repo.ZoneRepository;
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
