package ir.ac.kntu.divar.model.converters;

import ir.ac.kntu.divar.model.dto.NewResidentialRentDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialRent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResidentialRentDto2Model implements Converter<NewResidentialRentDTO
        , ResidentialRent> {
    @Override
    public ResidentialRent convert(NewResidentialRentDTO newResidentialRentDTO) {
        var src = Optional.of(newResidentialRentDTO).orElseThrow();
        Advertisement out = new ResidentialRent()
                .setRent(Double.valueOf(src.getRent()))
                .setDeposit(Double.valueOf(src.getPrepayment()))
                .setType(RealEstateAdvertisement.AdvertiserType
                        .converter(src.getAdvertiser()))
                .setArea(Double.valueOf(src.getArea()))
                .setRooms(src.getRooms()).setTitle(src.getTitle())
                .setDescription(src.getDescription())
                .setMobile(src.getMobile());
        return (ResidentialRent) out;
    }
}
