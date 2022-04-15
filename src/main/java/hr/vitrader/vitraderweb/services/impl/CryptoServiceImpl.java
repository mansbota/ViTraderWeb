package hr.vitrader.vitraderweb.services.impl;

import hr.vitrader.vitraderweb.converters.CryptoConverter;
import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.exceptions.AlreadyExistsException;
import hr.vitrader.vitraderweb.exceptions.NotFoundException;
import hr.vitrader.vitraderweb.model.Crypto;
import hr.vitrader.vitraderweb.repositories.CryptoRepository;
import hr.vitrader.vitraderweb.services.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CryptoServiceImpl implements CryptoService {

    private final CryptoRepository repository;
    private final CryptoConverter converter;

    @Override
    public List<CryptoDTO> getAllCryptos() {
        return repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public CryptoDTO getCryptoByName(String name) {
        return converter.convert(repository.findByName(name.toLowerCase(Locale.ROOT))
                .orElseThrow(() -> new NotFoundException("Crypto with name " + name + " not found.")));
    }

    @Override
    public CryptoDTO createCrypto(CryptoDTO crypto) {
        crypto.setName(crypto.getName().toLowerCase(Locale.ROOT));
        crypto.setTicker(crypto.getTicker().toUpperCase(Locale.ROOT));

        if (repository.findByName(crypto.getName()).isPresent())
            throw new AlreadyExistsException("Crypto with name " + crypto.getName() + " already exists.");

        repository.save(converter.convert(crypto));
        return crypto;
    }

    @Override
    public void deleteCrypto(String name) {
        Crypto crypto = repository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Crypto with name " + name + " not found."));

        repository.delete(crypto);
    }
}
