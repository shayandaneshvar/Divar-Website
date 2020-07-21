package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.converters.ResidentialRentDto2Model;
import ir.ac.kntu.divar.model.dto.NewResidentialRentDTO;
import ir.ac.kntu.divar.model.dto.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialRent;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialRentRepository;
import ir.ac.kntu.divar.model.service.UserService;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialRentService {
    private final ResidentialRentRepository repository;
    private final LocationService locationService;
    private final UserService userService;
    private final ResidentialRentDto2Model converter;
    public List<ResidentialRent> getAll() {
        return repository.findAll();
    }

    public List<ResidentialRent> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<ResidentialRent> filter(String input,
                                        RealEstateFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<ResidentialRent> result = repository
                .getAllByCityAndZoneIn(city, list);

        return (List<ResidentialRent>) RealEstateService.filterUtil(result, dto);
    }

    public ResidentialRent create(NewResidentialRentDTO input, String fileName) {
        ResidentialRent res = Objects.requireNonNull(converter.convert(input));
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
        User user = userService.getUser(input.getMobile());
        res = repository.save(res);
        user.getDivar().getUserAdvertisements().add(res);
        userService.saveUser(user);
        return res;
    }
}
