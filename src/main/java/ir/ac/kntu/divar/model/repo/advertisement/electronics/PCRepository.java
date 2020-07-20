package ir.ac.kntu.divar.model.repo.advertisement.electronics;

import ir.ac.kntu.divar.model.entity.advertisement.electronics.PC;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {
    List<PC> getAllByCity(City city);

    List<PC> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
