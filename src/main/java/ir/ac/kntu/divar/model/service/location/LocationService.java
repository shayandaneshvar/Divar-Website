package ir.ac.kntu.divar.model.service.location;

import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.location.CityRepository;
import ir.ac.kntu.divar.model.repo.location.ZoneRepository;
import ir.ac.kntu.divar.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LocationService {
    private final CityRepository cityRepository;
    private final ZoneRepository zoneRepository;

    @Loggable
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Loggable
    public List<Zone> getZones(City city) {
        return zoneRepository.findByCity(city);
    }

    @Loggable
    public List<Zone> getZonesContaining(String name) {
        return zoneRepository.findAllByNameContaining(name);
    }

    @Loggable
    public Optional<City> getCity(String city) {
        return cityRepository.getByName(city);
    }

    @Loggable
    public City saveCity(String input) {
        return cityRepository.save(new City().setName(input));
    }

    @Loggable
    public Optional<Zone> getZoneContainingAndCity(String zone, City city) {
        return zoneRepository.findAllByNameContainingAndCityEquals(zone, city);
    }

    @Loggable
    public Zone saveZone(String input, City city) {
        Zone zone = new Zone().setName(input).setCity(city);
        return zoneRepository.save(zone);
    }
}
