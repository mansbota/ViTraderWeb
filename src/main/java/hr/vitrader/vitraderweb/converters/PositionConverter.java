package hr.vitrader.vitraderweb.converters;

import hr.vitrader.vitraderweb.dto.PositionDTO;
import hr.vitrader.vitraderweb.model.Position;
import hr.vitrader.vitraderweb.repositories.CryptoRepository;
import hr.vitrader.vitraderweb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
@Component
public class PositionConverter implements Converter<Position, PositionDTO> {

    private final UserRepository userRepository;
    private final CryptoRepository cryptoRepository;

    @Override
    public PositionDTO convert(Position position) {
        return PositionDTO.builder()
                .cryptoId(position.getCrypto().getId())
                .amount(position.getAmount())
                .userId(position.getUser().getId())
                .build();
    }

    public Position convert(PositionDTO position) {
        return Position.builder()
                .id(null)
                .crypto(cryptoRepository.findById(position.getCryptoId())
                        .orElseThrow(() -> new RuntimeException(("Crypto with id " + position.getCryptoId() +
                                " not found."))))
                .user(userRepository.findById(position.getUserId())
                        .orElseThrow(() -> new RuntimeException("User with id " + position.getUserId() +
                                " not found.")))
                .amount(position.getAmount()).build();
    }
}
