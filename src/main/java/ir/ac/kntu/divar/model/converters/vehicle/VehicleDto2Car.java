package ir.ac.kntu.divar.model.converters.vehicle;

import ir.ac.kntu.divar.model.dto.NewVehicleDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleDto2Car implements
        Converter<NewVehicleDTO, Car> {
    @Override
    public Car convert(NewVehicleDTO newVehicleDTO) {
        var src = Optional.of(newVehicleDTO).orElseThrow();
        Advertisement out = new Car()
                .setKilometerage(src.getKilometerage().doubleValue())
                .setForRent(src.getForRent().equals("اجاره ای"))
                .setProductionYear(src.getProductionYear())
                .setModel(src.getModel())
                .setPrice(Double.valueOf(src.getPrice()))
                .setDescription(src.getDescription())
                .setTitle(src.getTitle())
                .setMobile(src.getMobile());
        return (Car) out;
    }
}
