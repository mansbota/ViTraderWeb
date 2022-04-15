package hr.vitrader.vitraderweb.services.impl;

import hr.vitrader.vitraderweb.converters.CryptoConverter;
import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.model.Crypto;
import hr.vitrader.vitraderweb.repositories.CryptoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CryptoServiceImplTest {

    @InjectMocks
    private CryptoServiceImpl service;

    @Mock
    private CryptoConverter converter;

    @Mock
    private CryptoRepository repository;

    @Test
    void getAllCryptos() {
        assertThat(service.getAllCryptos()).isNotNull();
    }

    @Test
    void getCryptoByName() {
        Crypto crypto = Crypto.builder().id(1L).ticker("BTC").name("Bitcoin").build();
        CryptoDTO cryptoDto = new CryptoDTO("BTC", "Bitcoin");

        when(repository.findByName(anyString())).thenReturn(Optional.of(crypto));
        when(converter.convert(crypto)).thenReturn(cryptoDto);

        CryptoDTO responseCrypto = service.getCryptoByName("Bitcoin");
        assertThat(cryptoDto).isEqualTo(responseCrypto);
    }

    @Test
    void createCrypto() {
        Crypto crypto = Crypto.builder().id(1L).ticker("BTC").name("Bitcoin").build();
        CryptoDTO cryptoDto = new CryptoDTO("BTC", "Bitcoin");

        when(converter.convert(cryptoDto)).thenReturn(crypto);
        when(repository.save(crypto)).thenReturn(crypto);

        CryptoDTO responseCrypto = service.createCrypto(cryptoDto);
        assertThat(cryptoDto).isEqualTo(responseCrypto);
    }
}