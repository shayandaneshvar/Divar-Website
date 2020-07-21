package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.converters.electronics.Mobile2AdDto;
import ir.ac.kntu.divar.model.converters.electronics.MobileDto2Model;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewMobileDTO;
import ir.ac.kntu.divar.model.dto.filters.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Mobile;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.MobileRepository;
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
public class MobileService implements Handler {
    private final MobileRepository repository;
    private final LocationService locationService;
    private final UserService userService;
    private final MobileDto2Model converter;
    private final Mobile2AdDto mapper;
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

    public Mobile create(NewMobileDTO input, String fileName) {
        Mobile res = Objects.requireNonNull(converter.convert(input));
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
