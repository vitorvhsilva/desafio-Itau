package desafio.itau.domain.service;

import desafio.itau.api.dto.EstatisticaDTO;
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

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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

    public ResponseEntity<EstatisticaDTO> estatisticas(OffsetDateTime horaInicial) {
        log.info("Calculando as estatísticas");
        List<Transacao> transacoes = transacaoRepository.getTransacoes();

        if (transacoes.isEmpty()) {
            return ResponseEntity.ok(new EstatisticaDTO());
        }

        BigDecimal[] valoresFiltrados = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .map(t -> t.getValor())
                .toArray(BigDecimal[]::new);

        DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);
        return ResponseEntity.ok(new EstatisticaDTO(doubleStream.summaryStatistics()));
    }
}
