package com.github.fiap.coleta_ci_cd.dto;

import com.github.fiap.coleta_ci_cd.model.Notificacao;

import java.time.LocalDate;

public record NotificacaoExibicaoDTO(
        Long id,
        Long rotaId,
        Long caminhaoId,
        String mensagem,
        LocalDate dataEnvio
) {

    public NotificacaoExibicaoDTO(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getRotaId(),
                notificacao.getCaminhaoId(),
                notificacao.getMensagem(),
                notificacao.getDataEnvio()
        );
    }

}
