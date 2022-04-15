package hr.vitrader.vitraderweb.services;

import hr.vitrader.vitraderweb.dto.PositionDTO;

import java.util.List;

public interface PositionService {

    List<PositionDTO> getAllPositionsByUser(Long userId);

    PositionDTO createPosition(PositionDTO position);

    PositionDTO updatePosition(PositionDTO position);

    void deletePosition(Long positionId);
}
