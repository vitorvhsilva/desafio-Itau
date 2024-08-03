package desafio.itau.domain.service.strategy;

import desafio.itau.api.dto.TransacaoDTO;

public interface ValidacaoStrategy {
    void validar(TransacaoDTO dto);
}
