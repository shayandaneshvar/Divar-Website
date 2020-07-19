package ir.ac.kntu.divar.model.repo.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialRent;
import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentialRentRepository extends JpaRepository<ResidentialRent
        , Long> {
    List<ResidentialRent> getAllByCity(City city);

    List<ResidentialRent> getAllByCityAndZoneIn(City city, List<Zone> list);
}
