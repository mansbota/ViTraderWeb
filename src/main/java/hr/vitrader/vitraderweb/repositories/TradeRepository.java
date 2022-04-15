package hr.vitrader.vitraderweb.repositories;

import hr.vitrader.vitraderweb.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
}
