package ir.ac.kntu.divar.model.service.advertisement.electronics;

import ir.ac.kntu.divar.model.dto.AdvertisementDTO;
import ir.ac.kntu.divar.model.dto.filters.GeneralFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.electronics.ElectronicsAdvertisement;
import ir.ac.kntu.divar.model.service.advertisement.Handler;
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
public class ElectronicsService implements Handler {
    private final ConsoleService consoleService;
    private final LaptopService laptopService;
    private final PCService pcService;
    private final MobileService mobileService;


    public static List<? extends ElectronicsAdvertisement> filterUtil(List<? extends
            ElectronicsAdvertisement> result, GeneralFilterDTO dto) {
        if (dto.getRequested() != dto.getOnSale()) {
            Advertisement.Type filter;
            if (dto.getOnSale()) {
                filter = Advertisement.Type.ON_SALE;
            } else {
                filter = Advertisement.Type.REQUESTED;
            }
            result = result.stream().filter(z -> z.getAdType().equals(filter))
                    .collect(Collectors.toList());
        }
        if (dto.getMaxPrice() != null) {
            result = result.stream().filter(z ->
                    z.getPrice() <= dto.getMaxPrice())
                    .collect(Collectors.toList());
        }
        if (dto.getMinPrice() != null) {
            result = result.stream().filter(z ->
                    z.getPrice() >= dto.getMinPrice())
                    .collect(Collectors.toList());
        }
        if (dto.getRemoveExchange() != dto.getExchangeOnly()) {
            boolean filter;
            if (dto.getRemoveExchange()) {
                filter = false;
            } else {
                filter = true;
            }
            result = result.stream().filter(z -> z.getExchange().equals(filter))
                    .collect(Collectors.toList());
        }

        if (dto.getRemoveNegotiation()) {
            result = result.stream().filter(z -> z.getPrice() != -2.0)
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

    public List<? extends ElectronicsAdvertisement> getAllByCity(String input) {
        List<ElectronicsAdvertisement> list =
                new ArrayList<>(pcService.getAllByCity(input));
        list.addAll(laptopService.getAllByCity(input));
        list.addAll(mobileService.getAllByCity(input));
        list.addAll(consoleService.getAllByCity(input));
        return list;
    }

    public List<? extends ElectronicsAdvertisement> filter(String input,
                                                           GeneralFilterDTO dto) {
        List<ElectronicsAdvertisement> list =
                new ArrayList<>(pcService.filter(input, dto));
        list.addAll(laptopService.filter(input, dto));
        list.addAll(mobileService.filter(input, dto));
        list.addAll(consoleService.filter(input, dto));
        return list;
    }

    @Override
    public AdvertisementDTO apply(Long aLong) {
        List<Handler> handlers = Arrays.asList(consoleService, pcService,
                laptopService, mobileService);
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

    public ElectronicsAdvertisement findById(Long id) {
        ElectronicsAdvertisement ad = consoleService.findById(id);
        if (ad == null) {
            ad = pcService.findById(id);
        }
        if (ad == null) {
            ad = mobileService.findById(id);
        }
        if (ad == null) {
            ad = laptopService.findById(id);
        }
        return ad;
    }
}
