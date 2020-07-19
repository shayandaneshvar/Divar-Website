package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.dto.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialRent;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialRentRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialRentService {
    private final ResidentialRentRepository repository;
    private final LocationService locationService;

    public List<ResidentialRent> getAll() {
        return repository.findAll();
    }

    public List<ResidentialRent> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<ResidentialRent> filter(String input, RealEstateFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<ResidentialRent> result = repository
                .getAllByCityAndZoneIn(city, list);

        return (List<ResidentialRent>) RealEstateService.filter(result,dto);
    }
}
