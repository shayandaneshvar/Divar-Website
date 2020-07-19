package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.dto.RealEstateFilterDTO;
import ir.ac.kntu.divar.model.entity.advertisement.Advertisement;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RealEstateService {
    private final CommercialSellService commercialSellService;
    private final ResidentialRentService residentialRentService;
    private final ResidentialSellService residentialSellService;

    public ArrayList<RealEstateAdvertisement> getAll() {
        ArrayList<RealEstateAdvertisement> result = new ArrayList<>();
        result.addAll(commercialSellService.getAll());
        result.addAll(residentialRentService.getAll());
        result.addAll(residentialSellService.getAll());
        return result;
    }

    public static List<? extends RealEstateAdvertisement> filter(List<? extends
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
}
