package hr.vitrader.vitraderweb.repositories;

import hr.vitrader.vitraderweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
