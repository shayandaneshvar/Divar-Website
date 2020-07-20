package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.dto.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.CommercialSell;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.CommercialSellRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CommercialSellService {
    private final CommercialSellRepository repository;
    private final LocationService locationService;
    public List<CommercialSell> getAll() {
        return repository.findAll();
    }

    public List<CommercialSell> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<ResidentialSell> filter(String input, RealEstateFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<CommercialSell> result = repository
                .getAllByCityAndZoneIn(city, list);
        return (List<ResidentialSell>) RealEstateService.filterUtil(result,dto);
    }
}
