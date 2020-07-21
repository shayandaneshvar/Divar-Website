package ir.ac.kntu.divar.model.converters.electronics;

import ir.ac.kntu.divar.model.dto.electronics.NewMobileDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Mobile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MobileDto2Model implements Converter<NewMobileDTO, Mobile> {
    @Override
    public Mobile convert(NewMobileDTO newMobileDTO) {
        var src = Optional.of(newMobileDTO).orElseThrow();
        Advertisement out = new Mobile()
                .setBrand(src.getBrand())
                .setTablet(src.getIsTablet().equals("تبلت"))
                .setPrice(Double.valueOf(src.getPrice()))
                .setDescription(src.getDescription())
                .setTitle(src.getTitle())
                .setMobile(src.getMobile());
        return (Mobile) out;
    }
}
