package desafio.itau.api.controller;

import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.domain.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "transacao", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> adicionar(@RequestBody @Valid TransacaoDTO dto) {
        return transacaoService.adicionar(dto);
    }

    @DeleteMapping
    public ResponseEntity<?> deletar() {
        return transacaoService.deletar();
    }
}
