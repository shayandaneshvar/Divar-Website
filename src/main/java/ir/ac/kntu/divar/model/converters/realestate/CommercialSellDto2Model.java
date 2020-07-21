package ir.ac.kntu.divar.model.converters.realestate;

import ir.ac.kntu.divar.model.dto.realestate.NewCommercialSellDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.CommercialSell;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommercialSellDto2Model implements Converter<NewCommercialSellDTO,
        CommercialSell> {
    @Override
    public CommercialSell convert(NewCommercialSellDTO newResidentialSellDTO) {
        var src = Optional.of(newResidentialSellDTO).orElseThrow();
        Advertisement out = new CommercialSell()
                .setLegalInstrument(src.getHasDocument().equals("دارد"))
                .setPrice(Double.valueOf(src.getPrice()))
                .setType(RealEstateAdvertisement.AdvertiserType
                        .converter(src.getAdvertiser()))
                .setArea(Double.valueOf(src.getArea()))
                .setRooms(src.getRooms()).setTitle(src.getTitle())
                .setDescription(src.getDescription())
                .setMobile(src.getMobile());
        return (CommercialSell) out;
    }
}
