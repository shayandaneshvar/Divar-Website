package ir.ac.kntu.divar.model.repo.advertisement.realestate;

import ir.ac.kntu.divar.model.entity.advertisement.realestate.ResidentialSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentialSellRepository extends JpaRepository<ResidentialSell
        , Long> {
}
