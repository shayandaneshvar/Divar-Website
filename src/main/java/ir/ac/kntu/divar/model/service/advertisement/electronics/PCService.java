package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.converters.electronics.Computer2AdDto;
import ir.ac.kntu.divar.model.converters.electronics.ElectronicsDto2PC;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewElectronicsDTO;
import ir.ac.kntu.divar.model.dto.filters.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.PC;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.PCRepository;
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
public class PCService implements Handler {
    private final LocationService locationService;
    private final PCRepository repository;
    private final UserService userService;
    private final ElectronicsDto2PC converter;
    private final Computer2AdDto<PC> mapper;

    public List<PC> getAll() {
        return repository.findAll();
    }

    public List<PC> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<PC> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<PC> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<PC>) ElectronicsService.filterUtil(result, dto);
    }

    public PC create(NewElectronicsDTO input, String fileName) {
        PC res = Objects.requireNonNull(converter.convert(input));
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
