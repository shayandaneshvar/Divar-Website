package ir.ac.kntu.divar.model.repo.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.CommercialSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialSellRepository extends JpaRepository<CommercialSell, Long> {

}
