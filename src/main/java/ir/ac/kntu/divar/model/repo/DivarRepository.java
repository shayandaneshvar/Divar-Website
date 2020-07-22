package ir.ac.kntu.divar.model.repo;

import ir.ac.kntu.divar.model.entity.user.Divar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DivarRepository extends JpaRepository<Divar, Long> {
}
