package com.github.fiap.coleta_ci_cd.service;

import com.github.fiap.coleta_ci_cd.dto.NotificacaoCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.NotificacaoExibicaoDTO;
import com.github.fiap.coleta_ci_cd.exception.NotificacaoNaoEncontradaException;
import com.github.fiap.coleta_ci_cd.model.Notificacao;
import com.github.fiap.coleta_ci_cd.repository.NotificacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoExibicaoDTO cadastrar(NotificacaoCadastroDTO notificacaoDTO) {
        try {
            Notificacao notificacao = new Notificacao();
            BeanUtils.copyProperties(notificacaoDTO, notificacao);

            Notificacao notificacaoSalva = notificacaoRepository.save(notificacao);
            return new NotificacaoExibicaoDTO(notificacaoSalva);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao cadastrar notificação", e);
        }
    }

    public NotificacaoExibicaoDTO buscarPorId(Long id) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(id);

        if (notificacaoOptional.isPresent()) {
            return new NotificacaoExibicaoDTO(notificacaoOptional.get());
        } else {
            throw new NotificacaoNaoEncontradaException("Notificação não encontrada!");
        }
    }

    public Page<NotificacaoExibicaoDTO> listarTodas(Pageable paginacao) {
        return notificacaoRepository
                .findAll(paginacao)
                .map(NotificacaoExibicaoDTO::new);

    }

    public NotificacaoExibicaoDTO atualizar(NotificacaoCadastroDTO notificacaoDTO) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(notificacaoDTO.id());

        if (notificacaoOptional.isPresent()) {
            Notificacao notificacao = new Notificacao();
            BeanUtils.copyProperties(notificacaoDTO, notificacao);

            return new NotificacaoExibicaoDTO(notificacaoRepository.save(notificacao));
        } else {
            throw new NotificacaoNaoEncontradaException("Notificação não encontrada!");
        }
    }

    public void excluir(Long id) {
        Optional<Notificacao> notificacaoOptional = notificacaoRepository.findById(id);

        if (notificacaoOptional.isPresent()) {
            notificacaoRepository.delete(notificacaoOptional.get());
        } else {
            throw new NotificacaoNaoEncontradaException("Notificação não encontrada!");
        }
    }

}
