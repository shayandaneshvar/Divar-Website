package ir.ac.kntu.divar.model.converters.electronics;

import ir.ac.kntu.divar.model.dto.electronics.NewLaptopDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Laptop;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LaptopDto2Model implements Converter<NewLaptopDTO, Laptop> {
    @Override
    public Laptop convert(NewLaptopDTO newLaptopDTO) {
        var src = Optional.of(newLaptopDTO).orElseThrow();
        Advertisement out = new Laptop()
                .setBrand(src.getBrand())
                .setPrice(Double.valueOf(src.getPrice()))
                .setDescription(src.getDescription())
                .setTitle(src.getTitle())
                .setMobile(src.getMobile());
        return (Laptop) out;
    }
}
