package ir.ac.kntu.divar.model.repo.advertisement.electronics;

import ir.ac.kntu.divar.model.entity.advertisement.electronics.Mobile;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
    List<Mobile> getAllByCity(City city);

    List<Mobile> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
