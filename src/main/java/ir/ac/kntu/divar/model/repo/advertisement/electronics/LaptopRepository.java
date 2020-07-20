package ir.ac.kntu.divar.model.repo.advertisement.electronics;

import ir.ac.kntu.divar.model.entity.advertisement.electronics.Laptop;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    List<Laptop> getAllByCity(City city);

    List<Laptop> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
