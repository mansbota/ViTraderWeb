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

    private Long id;
    private UserDTO userDto;
    private CryptoDTO cryptoDto;
    private double amount;
}
