package hr.vitrader.vitraderweb.repositories;

import hr.vitrader.vitraderweb.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long> {

    Optional<Crypto> findByTicker(String ticker);

    Optional<Crypto> findByName(String name);
}
