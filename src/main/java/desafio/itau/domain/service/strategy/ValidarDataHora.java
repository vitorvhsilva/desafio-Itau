package desafio.itau.domain.service.strategy;

import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.domain.exception.ItauException;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidarDataHora implements ValidacaoStrategy{
    @Override
    public void validar(TransacaoDTO dto) {
        if (dto.getDataHora().isAfter(OffsetDateTime.now())) throw new ItauException("Data da transação não aceita!");
    }
}
