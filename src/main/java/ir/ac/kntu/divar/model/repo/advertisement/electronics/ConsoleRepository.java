package ir.ac.kntu.divar.model.repo.advertisement.electronics;

import ir.ac.kntu.divar.model.entity.advertisement.electronics.Console;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    List<Console> getAllByCity(City city);

    List<Console> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
