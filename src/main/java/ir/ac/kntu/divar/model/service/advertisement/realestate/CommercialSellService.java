package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.CommercialSell;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.CommercialSellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CommercialSellService {
    private final CommercialSellRepository repository;

    public List<CommercialSell> getAll(){
        return repository.findAll();
    }
}
