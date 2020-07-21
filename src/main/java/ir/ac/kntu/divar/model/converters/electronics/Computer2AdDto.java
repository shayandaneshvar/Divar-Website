package ir.ac.kntu.divar.model.converters.electronics;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Computer;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Computer2AdDto<T extends Computer> implements Converter<T,
        AdvertisementDTO> {


    @Override
    public AdvertisementDTO convert(T t) {
        Computer src = Optional.of(t).orElseThrow();
        return new AdvertisementDTO()
                .setCity(src.getCity().getName())
                .setZone(Optional.ofNullable(src.getZone())
                        .orElse(new Zone().setName(null)).getName())
                .setPicture(src.getPicture())
                .setTitle(src.getTitle())
                .setDescription(src.getDescription())//advertisement
                .setPrice(src.getPrice().intValue());
    }
}
