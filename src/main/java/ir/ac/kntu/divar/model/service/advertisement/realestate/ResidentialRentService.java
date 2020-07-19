package ir.ac.kntu.divar.model.service.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialRent;
import ir.ac.kntu.divar.model.repo.advertisement.realestate.ResidentialRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResidentialRentService {
    private final ResidentialRentRepository repository;

    public List<ResidentialRent> getAll() {
        return repository.findAll();
    }
}
