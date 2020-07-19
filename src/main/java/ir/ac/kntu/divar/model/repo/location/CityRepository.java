package ir.ac.kntu.divar.model.repo.location;

import ir.ac.kntu.divar.model.entity.location.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
