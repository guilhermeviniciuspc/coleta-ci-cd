package com.github.fiap.coleta_ci_cd.service;

import com.github.fiap.coleta_ci_cd.dto.RastreadorCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.RastreadorExibicaoDTO;
import com.github.fiap.coleta_ci_cd.exception.RastreadorNaoEncontradoException;
import com.github.fiap.coleta_ci_cd.model.Rastreador;
import com.github.fiap.coleta_ci_cd.repository.RastreadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RastreadorService {

    @Autowired
    private RastreadorRepository rastreadorRepository;

    public RastreadorExibicaoDTO cadastrar(RastreadorCadastroDTO rastreadorDTO) {
        try {
            Rastreador rastreador = new Rastreador();
            BeanUtils.copyProperties(rastreadorDTO, rastreador);

            Rastreador rastreadorSalvo = rastreadorRepository.save(rastreador);
            return new RastreadorExibicaoDTO(rastreadorSalvo);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao cadastrar caminhão", e);
        }
    }

    public RastreadorExibicaoDTO buscarPorId(Long id) {
        Optional<Rastreador> rastreadorOptional = rastreadorRepository.findById(id);

        if (rastreadorOptional.isPresent()) {
            return new RastreadorExibicaoDTO(rastreadorOptional.get());
        } else {
            throw new RastreadorNaoEncontradoException("Rastreador não encontrado!");
        }
    }

    public Page<RastreadorExibicaoDTO> listarTodos(Pageable paginacao) {
        return rastreadorRepository
                .findAll(paginacao)
                .map(RastreadorExibicaoDTO::new);

    }

    public RastreadorExibicaoDTO atualizar(RastreadorCadastroDTO rastreadorDTO) {
        Optional<Rastreador> rastreadorOptional = rastreadorRepository.findById(rastreadorDTO.id());

        if (rastreadorOptional.isPresent()) {
            Rastreador rastreador = new Rastreador();
            BeanUtils.copyProperties(rastreadorDTO, rastreador);

            return new RastreadorExibicaoDTO(rastreadorRepository.save(rastreador));
        } else {
            throw new RastreadorNaoEncontradoException("Rastreador não encontrado!");
        }
    }

    public void excluir(Long id) {
        Optional<Rastreador> rastreadorOptional = rastreadorRepository.findById(id);

        if (rastreadorOptional.isPresent()) {
            rastreadorRepository.delete(rastreadorOptional.get());
        } else {
            throw new RastreadorNaoEncontradoException("Rastreador não encontrado!");
        }
    }

}
