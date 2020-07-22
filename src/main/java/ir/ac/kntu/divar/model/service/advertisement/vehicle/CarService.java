package ir.ac.kntu.divar.model.service.advertisement.vehicle;

import ir.ac.kntu.divar.model.converters.vehicle.Vehicle2AdDto;
import ir.ac.kntu.divar.model.converters.vehicle.VehicleDto2Car;
import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.NewVehicleDTO;
import ir.ac.kntu.divar.model.dto.filters.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.entity.user.User;
import ir.ac.kntu.divar.model.repo.advertisement.vehicle.CarRepository;
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
public class CarService implements Handler {
    private final LocationService locationService;
    private final CarRepository repository;
    private final UserService userService;
    private final VehicleDto2Car converter;
    private final Vehicle2AdDto<Car> mapper;

    public List<Car> getAll() {
        return repository.findAll();
    }

    public List<Car> getAllByCity(String input) {
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }

    public List<Car> filter(String input, GeneralFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        City city = locationService.getCity(input).orElseThrow();
        List<Car> result = repository.getAllByCityAndZoneIn(city, list);
        return (List<Car>) VehicleService.filterUtil(result, dto);
    }

    public Car create(NewVehicleDTO input, String fileName) {
        Car res = Objects.requireNonNull(converter.convert(input));
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

    public Car findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
