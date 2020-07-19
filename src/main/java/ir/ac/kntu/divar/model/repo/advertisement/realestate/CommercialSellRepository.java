package ir.ac.kntu.divar.model.repo.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.CommercialSell;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommercialSellRepository extends JpaRepository<CommercialSell, Long> {

    List<CommercialSell> getAllByCity(City city);

    List<CommercialSell> getAllByCityAndZoneIn(City city, List<Zone> list);
}
