package ir.ac.kntu.divar.model.repo.advertisement.vehicle;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> getAllByCity(City city);
    List<Car> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
