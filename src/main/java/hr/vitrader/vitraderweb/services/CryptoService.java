package hr.vitrader.vitraderweb.services;

import hr.vitrader.vitraderweb.dto.CryptoDTO;

import java.util.List;

public interface CryptoService {

    List<CryptoDTO> getAllCryptos();

    CryptoDTO getCryptoByName(String name);

    CryptoDTO createCrypto(CryptoDTO crypto);

    void deleteCrypto(String name);
}
