package hr.vitrader.vitraderweb.converters;

import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.model.Crypto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@Component
public class CryptoConverter implements Converter<Crypto, CryptoDTO> {

    @Override
    public CryptoDTO convert(Crypto crypto) {
        return CryptoDTO.builder()
                .name(crypto.getName())
                .ticker(crypto.getTicker())
                .build();
    }

    public Crypto convert(CryptoDTO crypto) {
        return Crypto.builder()
                .id(null)
                .ticker(crypto.getTicker())
                .name(crypto.getName())
                .build();
    }
}
