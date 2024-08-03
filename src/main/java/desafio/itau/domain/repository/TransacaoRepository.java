package desafio.itau.domain.repository;

import desafio.itau.domain.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Data
public class TransacaoRepository {
    private List<Transacao> transacoes;
}
