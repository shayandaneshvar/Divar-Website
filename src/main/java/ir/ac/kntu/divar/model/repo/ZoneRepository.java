package ir.ac.kntu.divar.model.repo;

import ir.ac.kntu.divar.model.entity.City;
import ir.ac.kntu.divar.model.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    List<Zone> findByCity(City city);
}
