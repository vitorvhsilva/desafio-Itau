package desafio.itau.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class TransacaoDTO {
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
