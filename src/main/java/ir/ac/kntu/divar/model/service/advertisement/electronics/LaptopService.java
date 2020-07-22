package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.converters.electronics.Laptop2AdDto;
import ir.ac.kntu.divar.model.converters.electronics.LaptopDto2Model;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.electronics.NewLaptopDTO;
import ir.ac.kntu.divar.model.dto.filters.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Laptop;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.electronics.LaptopRepository;
import ir.ac.kntu.divar.model.service.UserService;
import ir.ac.kntu.divar.model.service.advertisement.Handler;
import ir.ac.kntu.divar.model.service.location.LocationService;
import ir.ac.kntu.divar.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LaptopService implements Handler {
    private final LaptopRepository repository;
    private final LocationService locationService;
    private final UserService userService;
    private final LaptopDto2Model converter;
    private final Laptop2AdDto mapper;

    public List<Laptop> getAll() {
        return repository.findAll();
    }

    @Loggable
    public List<Laptop> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    @Loggable
    public List<Laptop> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Laptop> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Laptop>) ElectronicsService.filterUtil(result, dto);
    }

    @Loggable
    public Laptop create(NewLaptopDTO input, String fileName) {
        Laptop res = Objects.requireNonNull(converter.convert(input));
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
        return mapper.convert(findById(aLong));
    }

    public Laptop findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
