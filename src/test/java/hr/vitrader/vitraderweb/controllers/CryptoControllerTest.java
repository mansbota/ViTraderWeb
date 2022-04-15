package hr.vitrader.vitraderweb.controllers;

import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.services.CryptoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CryptoControllerTest {

    MockMvc mvc;

    @InjectMocks
    CryptoController controller;

    @Mock
    CryptoService service;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllCryptos() throws Exception {
        List<CryptoDTO> cryptos =
                Arrays.asList(
                        CryptoDTO.builder().name("bitcoin").ticker("BTC").build(),
                        CryptoDTO.builder().name("ethereum").ticker("ETH").build()
                );

        when(service.getAllCryptos()).thenReturn(cryptos);

        mvc.perform(get("/api/crypto/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{\"name\": \"bitcoin\", \"ticker\": \"BTC\"}, " +
                                  "{\"name\": \"ethereum\", \"ticker\": \"ETH\"}]"))
                .andDo(print());
    }

    @Test
    void getCryptoByName() throws Exception {
        CryptoDTO crypto = CryptoDTO.builder().name("bitcoin").ticker("BTC").build();

        when(service.getCryptoByName(anyString())).thenReturn(crypto);

        mvc.perform(get("/api/crypto/bitcoin"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"bitcoin\", \"ticker\": \"BTC\"}"))
                .andDo(print());
    }

    @Test
    void createCrypto() throws Exception {
        CryptoDTO crypto = CryptoDTO.builder().name("bitcoin").ticker("BTC").build();

        when(service.createCrypto(crypto)).thenReturn(crypto);

        mvc.perform(
                post("/api/crypto/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"bitcoin\", \"ticker\": \"BTC\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"name\": \"bitcoin\", \"ticker\": \"BTC\"}"))
                .andDo(print());
    }
}