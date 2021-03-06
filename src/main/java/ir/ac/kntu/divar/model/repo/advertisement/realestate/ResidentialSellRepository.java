package ir.ac.kntu.divar.model.repo.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentialSellRepository extends JpaRepository<ResidentialSell
        , Long> {
    List<ResidentialSell> getAllByCity(City city);
    List<ResidentialSell> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
