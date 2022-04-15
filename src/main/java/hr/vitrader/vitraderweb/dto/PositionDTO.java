package hr.vitrader.vitraderweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {

    private Long userId;
    private Long cryptoId;
    private double amount;
}
