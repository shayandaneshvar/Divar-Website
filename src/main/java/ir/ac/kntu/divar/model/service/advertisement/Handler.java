package ir.ac.kntu.divar.model.service.advertisement;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;

import java.util.function.Function;

@FunctionalInterface
public interface Handler extends Function<Long, AdvertisementDTO> {
    default AdvertisementDTO handle(Long id) {
        return apply(id);
    }
}
