package desafio.itau.domain.service;

import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.domain.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoService {

    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper;

    public ResponseEntity<TransacaoDTO> adicionar(TransacaoDTO dto) {
        return ResponseEntity.ok(dto);
    }
}
