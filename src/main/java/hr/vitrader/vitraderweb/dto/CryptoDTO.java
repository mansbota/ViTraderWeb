package hr.vitrader.vitraderweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CryptoDTO {

    private Long id;
    private String ticker;
    private String name;
}
