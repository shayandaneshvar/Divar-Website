package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.filters.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import ir.ac.kntu.divar.model.entity.location.Zone;
import ir.ac.kntu.divar.model.service.advertisement.Handler;
import ir.ac.kntu.divar.model.service.location.LocationService;
import ir.ac.kntu.divar.util.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RealEstateService implements Handler {
    private final CommercialSellService commercialSellService;
    private final ResidentialRentService residentialRentService;
    private final ResidentialSellService residentialSellService;
    private final LocationService locationService;

    @Loggable
    public ArrayList<RealEstateAdvertisement> getAll() {
        ArrayList<RealEstateAdvertisement> result = new ArrayList<>();
        result.addAll(commercialSellService.getAll());
        result.addAll(residentialRentService.getAll());
        result.addAll(residentialSellService.getAll());
        return result;
    }

    @Loggable
    public static List<? extends RealEstateAdvertisement> filterUtil(List<? extends
            RealEstateAdvertisement> result, RealEstateFilterDTO dto) {
        if (dto.getPersonal() != dto.getRealEstate()) {
            RealEstateAdvertisement.AdvertiserType filter;
            if (dto.getPersonal()) {
                filter = RealEstateAdvertisement.AdvertiserType.REAL_ESTATE;
            } else {
                filter = RealEstateAdvertisement.AdvertiserType.PERSONAL;
            }
            result = result.stream().filter(z -> z.getType().equals(filter))
                    .collect(Collectors.toList());
        }
        if (dto.getUrgentOnly()) {
            result = result.stream().filter(Advertisement::getUrgent)
                    .collect(Collectors.toList());
        }
        if (dto.getWithImageOnly()) {
            result = result.stream().filter(Advertisement::getHasImage)
                    .collect(Collectors.toList());
        }
        return result;
    }

    @Loggable
    public List<? extends RealEstateAdvertisement> filter(String input,
                                                          RealEstateFilterDTO dto) {
        List<Zone> list = locationService
                .getZonesContaining(dto.getZone() == null ? "" : dto.getZone());
        List<RealEstateAdvertisement> result = new ArrayList<>(residentialSellService.filter(input, dto));
        result.addAll(residentialRentService.filter(input, dto));
        result.addAll(commercialSellService.filter(input, dto));
        return result;
    }

    @Loggable
    public List<? extends RealEstateAdvertisement> getAllByCity(String city) {
        List<RealEstateAdvertisement> result =
                new ArrayList<>(commercialSellService.getAllByCity(city));
        result.addAll(residentialRentService.getAllByCity(city));
        result.addAll(residentialSellService.getAllByCity(city));
        return result;
    }

    @Override
    public AdvertisementDTO apply(Long aLong) {
        List<Handler> handlers = Arrays.asList(residentialRentService,
                residentialSellService, commercialSellService);
        return handlers.stream().map(z -> {
            AdvertisementDTO res;
            try {
                res = z.apply(aLong);
            } catch (Exception ignored) {
                res = null;
            }
            return res;
        }).filter(Objects::nonNull).findFirst().orElse(null);
    }

    @Loggable
    public RealEstateAdvertisement findById(Long id) {
        RealEstateAdvertisement ad = commercialSellService.findById(id);
        if (ad == null) {
            ad = residentialRentService.findById(id);
        }
        if (ad == null) {
            ad = residentialSellService.findById(id);
        }
        return ad;
    }
}
