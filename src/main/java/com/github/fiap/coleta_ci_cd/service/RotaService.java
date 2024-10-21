package com.github.fiap.coleta_ci_cd.service;

import com.github.fiap.coleta_ci_cd.dto.RotaCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.RotaExibicaoDTO;
import com.github.fiap.coleta_ci_cd.exception.RotaNaoEncontradaException;
import com.github.fiap.coleta_ci_cd.model.Rota;
import com.github.fiap.coleta_ci_cd.repository.RotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public RotaExibicaoDTO cadastrar(RotaCadastroDTO rotaDTO) {
        try {
            Rota rota = new Rota();
            BeanUtils.copyProperties(rotaDTO, rota);

            Rota rotaSalva = rotaRepository.save(rota);
            return new RotaExibicaoDTO(rotaSalva);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao cadastrar rota", e);
        }
    }

    public RotaExibicaoDTO buscarPorId(Long id) {
        Optional<Rota> rotaOptional = rotaRepository.findById(id);

        if (rotaOptional.isPresent()) {
            return new RotaExibicaoDTO(rotaOptional.get());
        } else {
            throw new RotaNaoEncontradaException("Rota não encontrada!");
        }
    }

    public Page<RotaExibicaoDTO> listarTodas(Pageable paginacao) {
        return rotaRepository
                .findAll(paginacao)
                .map(RotaExibicaoDTO::new);

    }

    public RotaExibicaoDTO atualizar(RotaCadastroDTO rotaDTO) {
        Optional<Rota> rotaOptional = rotaRepository.findById(rotaDTO.id());

        if (rotaOptional.isPresent()) {
            Rota rota = new Rota();
            BeanUtils.copyProperties(rotaDTO, rota);

            return new RotaExibicaoDTO(rotaRepository.save(rota));
        } else {
            throw new RotaNaoEncontradaException("Rota não encontrada!");
        }
    }

    public void excluir(Long id) {
        Optional<Rota> rotaOptional = rotaRepository.findById(id);

        if (rotaOptional.isPresent()) {
            rotaRepository.delete(rotaOptional.get());
        } else {
            throw new RotaNaoEncontradaException("Rota não encontrada!");
        }
    }

}
