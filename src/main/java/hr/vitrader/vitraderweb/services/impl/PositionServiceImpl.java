package hr.vitrader.vitraderweb.services.impl;

import hr.vitrader.vitraderweb.converters.PositionConverter;
import hr.vitrader.vitraderweb.dto.PositionDTO;
import hr.vitrader.vitraderweb.repositories.PositionRepository;
import hr.vitrader.vitraderweb.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository repository;
    private final PositionConverter converter;

    @Override
    public List<PositionDTO> getAllPositionsByUser(Long userId) {
        return repository.findAll().stream().filter(pos -> pos.getUser().getId().equals(userId))
                .map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public PositionDTO createPosition(PositionDTO position) {
        return null;
    }

    @Override
    public PositionDTO updatePosition(PositionDTO position) {
        return null;
    }

    @Override
    public void deletePosition(Long positionId) {

    }
}
