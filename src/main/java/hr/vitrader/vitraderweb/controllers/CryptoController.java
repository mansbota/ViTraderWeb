package hr.vitrader.vitraderweb.controllers;

import hr.vitrader.vitraderweb.dto.CryptoDTO;
import hr.vitrader.vitraderweb.services.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/crypto")
public class CryptoController {

    private final CryptoService service;

    @GetMapping("/all")
    ResponseEntity<List<CryptoDTO>> getAllCryptos() {
        List<CryptoDTO> allCryptos = service.getAllCryptos();
        return ResponseEntity.ok(allCryptos);
    }

    @GetMapping("/{name}")
    ResponseEntity<CryptoDTO> getCryptoByName(@PathVariable String name) {
        CryptoDTO crypto = service.getCryptoByName(name);
        return ResponseEntity.ok(crypto);
    }

    @PostMapping("/new")
    ResponseEntity<CryptoDTO> createCrypto(@RequestBody CryptoDTO crypto) {
        CryptoDTO addedCrypto = service.createCrypto(crypto);
        return new ResponseEntity<>(addedCrypto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    ResponseEntity<CryptoDTO> deleteCrypto(@PathVariable String name) {
        service.deleteCrypto(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
