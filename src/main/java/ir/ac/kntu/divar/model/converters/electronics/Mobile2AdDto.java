package ir.ac.kntu.divar.model.converters.electronics;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Mobile;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mobile2AdDto implements Converter<Mobile, AdvertisementDTO> {
    @Override
    public AdvertisementDTO convert(Mobile mobile) {
        Mobile src = Optional.of(mobile).orElseThrow();
        return new AdvertisementDTO()
                .setCity(src.getCity().getName())
                .setZone(Optional.ofNullable(src.getZone())
                        .orElse(new Zone().setName(null)).getName())
                .setPicture(src.getPicture())
                .setTitle(src.getTitle())
                .setDescription(src.getDescription())//advertisement
                .setPrice(src.getPrice().intValue())
                .setBrand(src.getBrand())
                .setIsTablet(src.getTablet() ? "تبلت" : "گوشی هوشمند");
    }
}
