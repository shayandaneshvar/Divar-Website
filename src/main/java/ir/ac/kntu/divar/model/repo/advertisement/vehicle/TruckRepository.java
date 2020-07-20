package ir.ac.kntu.divar.model.repo.advertisement.vehicle;

import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Car;
import ir.ac.kntu.divar.model.entity.advertisement.vehicle.Truck;
import ir.ac.kntu.divar.model.entity.location.City;
import ir.ac.kntu.divar.model.entity.location.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> getAllByCity(City city);
    List<Truck> getAllByCityAndZoneIn(City city, List<Zone> zones);
}
