package com.github.fiap.coleta_ci_cd.service;

import com.github.fiap.coleta_ci_cd.dto.CaminhaoCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.CaminhaoExibicaoDTO;
import com.github.fiap.coleta_ci_cd.exception.CaminhaoJaCadastradoException;
import com.github.fiap.coleta_ci_cd.exception.CaminhaoNaoEncontradoException;
import com.github.fiap.coleta_ci_cd.model.Caminhao;
import com.github.fiap.coleta_ci_cd.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public CaminhaoExibicaoDTO cadastrar(CaminhaoCadastroDTO caminhaoDTO) {

        if (caminhaoRepository.existsByPlaca(caminhaoDTO.placa())) {
            throw new CaminhaoJaCadastradoException("Caminhão já cadastrado!");
        }

        if (caminhaoRepository.existsByRenavam(caminhaoDTO.renavam())) {
            throw new CaminhaoJaCadastradoException("Caminhão já cadastrado!");
        }

        if (caminhaoRepository.existsByChassi(caminhaoDTO.chassi())) {
            throw new CaminhaoJaCadastradoException("Caminhão já cadastrado!");
        }

        try {
            Caminhao caminhao = new Caminhao();
            BeanUtils.copyProperties(caminhaoDTO, caminhao);

            Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);
            return new CaminhaoExibicaoDTO(caminhaoSalvo);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao cadastrar caminhão", e);
        }
    }

    public CaminhaoExibicaoDTO buscarPorId(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            return new CaminhaoExibicaoDTO(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoEncontradoException("Caminhão não encontrado!");
        }
    }

    public Page<CaminhaoExibicaoDTO> listarTodos(Pageable paginacao) {
        return caminhaoRepository
                .findAll(paginacao)
                .map(CaminhaoExibicaoDTO::new);

    }

    public CaminhaoExibicaoDTO atualizar(CaminhaoCadastroDTO caminhaoDTO) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(caminhaoDTO.id());

        if (caminhaoOptional.isPresent()) {
            Caminhao caminhao = new Caminhao();
            BeanUtils.copyProperties(caminhaoDTO, caminhao);

            return new CaminhaoExibicaoDTO(caminhaoRepository.save(caminhao));
        } else {
            throw new CaminhaoNaoEncontradoException("Caminhão não encontrado!");
        }
    }

    public void excluir(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoEncontradoException("Caminhão não encontrado!");
        }
    }

}
