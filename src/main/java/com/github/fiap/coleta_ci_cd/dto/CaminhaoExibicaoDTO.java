package com.github.fiap.coleta_ci_cd.dto;

import com.github.fiap.coleta_ci_cd.model.Caminhao;

public record CaminhaoExibicaoDTO(
        Long id,
        String caminhao,
        String placa,
        Long renavam,
        String chassi,
        Integer dataAnoFabricacao,
        Integer dataAnoModelo
) {

    public CaminhaoExibicaoDTO(Caminhao caminhao) {
        this(
                caminhao.getId(),
                caminhao.getCaminhao(),
                caminhao.getPlaca(),
                caminhao.getRenavam(),
                caminhao.getChassi(),
                caminhao.getDataAnoFabricacao(),
                caminhao.getDataAnoModelo()
        );
    }

}