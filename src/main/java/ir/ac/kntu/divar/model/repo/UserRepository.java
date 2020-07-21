package ir.ac.kntu.divar.model.repo;

import ir.ac.kntu.divar.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByMobile(String mobile);
}
