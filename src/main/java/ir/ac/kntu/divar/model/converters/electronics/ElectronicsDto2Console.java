package ir.ac.kntu.divar.model.converters.electronics;

import ir.ac.kntu.divar.model.dto.electronics.NewElectronicsDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.Console;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ElectronicsDto2Console implements Converter<NewElectronicsDTO,
        Console> {
    @Override
    public Console convert(NewElectronicsDTO newElectronicsDTO) {
        var src = Optional.of(newElectronicsDTO).orElseThrow();
        Advertisement out = new Console()
                .setPrice(Double.valueOf(src.getPrice()))
                .setDescription(src.getDescription())
                .setTitle(src.getTitle())
                .setMobile(src.getMobile());
        return (Console) out;
    }
}