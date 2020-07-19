package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.RealEstateAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RealEstateService {
    private final CommercialSellService commercialSellService;
    private final ResidentialRentService residentialRentService;
    private final ResidentialSellService residentialSellService;

    public final ArrayList<RealEstateAdvertisement> getAll() {
        ArrayList<RealEstateAdvertisement> result = new ArrayList<>();
        result.addAll(commercialSellService.getAll());
        result.addAll(residentialRentService.getAll());
        result.addAll(residentialSellService.getAll());
        return result;
    }
}
