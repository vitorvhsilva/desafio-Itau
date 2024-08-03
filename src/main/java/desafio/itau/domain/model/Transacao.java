package desafio.itau.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class Transacao {
    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
