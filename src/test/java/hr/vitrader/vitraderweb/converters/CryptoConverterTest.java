package hr.vitrader.vitraderweb.converters;

import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.model.Crypto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class CryptoConverterTest {

    CryptoConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new CryptoConverter();
    }

    @Test
    void toDto() {
        Crypto crypto = Crypto.builder().id(null).ticker("BTC").name("Bitcoin").build();
        CryptoDTO cryptoDto = CryptoDTO.builder().ticker("BTC").name("Bitcoin").build();

        assertThat(converter.convert(crypto)).isEqualTo(cryptoDto);
    }

    @Test
    void fromDto() {
        Crypto crypto = Crypto.builder().id(null).ticker("BTC").name("Bitcoin").build();
        CryptoDTO cryptoDto = CryptoDTO.builder().ticker("BTC").name("Bitcoin").build();

        assertThat(converter.convert(cryptoDto)).isEqualTo(crypto);
    }
}