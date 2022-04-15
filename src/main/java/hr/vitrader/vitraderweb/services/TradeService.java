package hr.vitrader.vitraderweb.services;

import hr.vitrader.vitraderweb.dto.TradeDTO;

import java.util.List;

public interface TradeService {

    List<TradeDTO> getAllTradesByUser(Long userId);

    TradeDTO createTrade(TradeDTO trade);
}
