package desafio.itau.domain.service;

import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.domain.model.Transacao;
import desafio.itau.domain.repository.TransacaoRepository;
import desafio.itau.domain.service.strategy.ValidacaoStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransacaoService {

    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper;
    private List<ValidacaoStrategy> validacoes;

    public ResponseEntity<TransacaoDTO> adicionar(TransacaoDTO dto) {
        log.info("Adicionando transação");
        validacoes.forEach(v -> v.validar(dto));

        transacaoRepository.salvar(modelMapper.map(dto, Transacao.class));
        log.info("Transação salva");

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<?> deletar() {
        log.info("Deletando as transações");
        transacaoRepository.limpar();
        return ResponseEntity.ok().build();
    }
}
