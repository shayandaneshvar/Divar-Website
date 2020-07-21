package ir.ac.kntu.divar.model.converters.realestate;

import ir.ac.kntu.divar.model.dto.realestate.NewResidentialSellDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResidentialSellDto2Model implements Converter<NewResidentialSellDTO,ResidentialSell> {
    @Override
    public ResidentialSell convert(NewResidentialSellDTO newResidentialSellDTO) {
        var src = Optional.of(newResidentialSellDTO).orElseThrow();
        Advertisement out = new ResidentialSell()
                .setPrice(Double.valueOf(src.getPrice()))
                .setType(RealEstateAdvertisement.AdvertiserType
                .converter(src.getAdvertiser()))
                .setArea(Double.valueOf(src.getArea()))
                .setRooms(src.getRooms()).setTitle(src.getTitle())
                .setDescription(src.getDescription())
                .setMobile(src.getMobile());
        return (ResidentialSell) out;
    }
}
