package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.converters.realestate.ResidentialSell2AdDto;
import ir.ac.kntu.divar.model.converters.realestate.ResidentialSellDto2Model;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.realestate.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.dto.filters.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialSellRepository;
import ir.ac.kntu.divar.model.service.UserService;
import ir.ac.kntu.divar.model.service.advertisement.Handler;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialSellService implements Handler {
    private final ResidentialSellRepository repository;
    private final LocationService locationService;
    private final ResidentialSellDto2Model converter;
    private final UserService userService;
    private final ResidentialSell2AdDto mapper;

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
            res.setHasImage(true);
            res.setPicture(fileName);
        } else {
            res.setHasImage(false);
        }
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
    @Override
    public AdvertisementDTO apply(Long aLong) {
        return mapper.convert(repository.getOne(aLong));
    }
}
