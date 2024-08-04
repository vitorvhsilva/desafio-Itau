package desafio.itau.api.controller;

import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.domain.service.TransacaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping(value = "estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class EstatisticasController {

    private TransacaoService transacaoService;
    private final Integer intervaloEmSegundos = 60;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatisticas() {
        OffsetDateTime horaInicial = OffsetDateTime.now().minusSeconds(intervaloEmSegundos);
        return transacaoService.estatisticas(horaInicial);
    }
}
