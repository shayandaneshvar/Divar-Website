package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialSellRepository;
import ir.ac.kntu.divar.model.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialSellService {
    private final ResidentialSellRepository repository;
    private final LocationService locationService;

    public List<ResidentialSell> getAll(){
        return repository.findAll();
    }

    public List<ResidentialSell> getAllByCity(String input){
        City city = locationService.getCity(input).orElseThrow();
        return repository.getAllByCity(city);
    }
}
