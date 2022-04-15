package hr.vitrader.vitraderweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeDTO {

    private Long cryptoId;
    private Long userId;
    private String tradeType;
    private double cryptoAmount;
    private double dollarsAmount;
}
