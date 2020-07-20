package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.converters.ResidentialSellDto2Model;
import ir.ac.kntu.divar.model.dto.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.dto.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialSellRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialSellService {
    private final ResidentialSellRepository repository;
    private final LocationService locationService;
    private final ResidentialSellDto2Model converter;



    public List<ResidentialSell> getAll() {
        return repository.findAll();
    }

    public List<ResidentialSell> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<ResidentialSell> filter(String input, RealEstateFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<ResidentialSell> result = repository
                .getAllByCityAndZoneIn(city, list);
        return (List<ResidentialSell>) RealEstateService.filterUtil(result, dto);
    }

    public ResidentialSell create(NewResidentialSellDTO input, String fileName) {
        ResidentialSell res = Objects.requireNonNull(converter.convert(input));
        if (fileName != null) {
            res.setHasImage(false);
            res.setPicture(fileName);
        }
        res.setHasImage(true);
        City city = locationService.getCity(input.getCity())
                .orElseGet(() -> locationService.saveCity(input.getCity()));
        res.setCity(city);
        if (input.getZone() != null) {
            Zone zone = locationService.getZoneContainingAndCity(input.getZone()
                    , city).orElseGet(() -> locationService
                    .saveZone(input.getZone(), city));
            res.setZone(zone);
        }
        // FIXME: 7/21/2020
        //user!
        return repository.save(res);
    }
}
