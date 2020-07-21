package ir.ac.kntu.divar.model.converters.vehicle;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Truck;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.VehicleAdvertisement;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Vehicle2AdDto<T extends VehicleAdvertisement> implements Converter<T,
        AdvertisementDTO> {
    @Override
    public AdvertisementDTO convert(T t) {
        if (t instanceof Car) {
            Car src = (Car) Optional.of(t).orElseThrow();
            return new AdvertisementDTO()
                    .setCity(src.getCity().getName())
                    .setZone(Optional.ofNullable(src.getZone())
                            .orElse(new Zone().setName(null)).getName())
                    .setPicture(src.getPicture())
                    .setTitle(src.getTitle())
                    .setDescription(src.getDescription())//advertisement
                    .setPrice(src.getPrice().intValue())
                    .setKilometerage(src.getKilometerage().intValue());
        }
        Truck src = (Truck) Optional.of(t).orElseThrow();
        return new AdvertisementDTO()
                .setCity(src.getCity().getName())
                .setZone(Optional.ofNullable(src.getZone())
                        .orElse(new Zone().setName(null)).getName())
                .setPicture(src.getPicture())
                .setTitle(src.getTitle())
                .setDescription(src.getDescription())//advertisement
                .setPrice(src.getPrice().intValue())
                .setKilometerage(src.getKilometerage().intValue());
    }
}
