package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialSellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialSellService {
    private final ResidentialSellRepository repository;

    public List<ResidentialSell> getAll(){
        return repository.findAll();
    }
}
