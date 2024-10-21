package com.github.fiap.coleta_ci_cd.dto;

import com.github.fiap.coleta_ci_cd.model.Rota;

import java.time.LocalDate;

public record RotaExibicaoDTO(
        Long id,
        Long caminhaoId,
        LocalDate dataAgendamento,
        String rua,
        String bairro,
        String cidade,
        String estado,
        String uf,
        String cep
) {

    public RotaExibicaoDTO(Rota rota) {
        this(
                rota.getId(),
                rota.getCaminhaoId(),
                rota.getDataAgendamento(),
                rota.getRua(),
                rota.getBairro(),
                rota.getCidade(),
                rota.getEstado(),
                rota.getUf(),
                rota.getCep()
        );
    }

}

