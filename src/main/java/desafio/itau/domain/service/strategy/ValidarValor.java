package desafio.itau.domain.service.strategy;

import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.domain.exception.ItauException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidarValor implements ValidacaoStrategy{

    @Override
    public void validar(TransacaoDTO dto) {
        if (dto.getValor().compareTo(BigDecimal.ZERO) < 0 ) throw new ItauException("Valor da transação negativo");
    }
}
