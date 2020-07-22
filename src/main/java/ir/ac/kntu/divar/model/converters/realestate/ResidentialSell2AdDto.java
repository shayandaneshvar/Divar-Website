package ir.ac.kntu.divar.model.converters.realestate;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResidentialSell2AdDto implements Converter<ResidentialSell, AdvertisementDTO> {
    @Override
    public AdvertisementDTO convert(ResidentialSell residentialSell) {
        ResidentialSell src = Optional.of(residentialSell).orElseThrow();
        return new AdvertisementDTO()
                .setCity(src.getCity().getName())
                .setZone(Optional.ofNullable(src.getZone())
                        .orElse(new Zone().setName(null)).getName())
                .setPicture(src.getPicture())
                .setTitle(src.getTitle())
                .setDescription(src.getDescription())//advertisement
                .setRooms(src.getRooms())
                .setArea(src.getArea().intValue())
                .setAdvertiser(src.getType()
                        .equals(RealEstateAdvertisement.AdvertiserType.
                                PERSONAL) ? "شخصی" : "املاک")
                .setPrice(src.getPrice().intValue());
    }
}
