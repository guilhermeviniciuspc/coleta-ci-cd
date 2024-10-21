package com.github.fiap.coleta_ci_cd.dto;

import com.github.fiap.coleta_ci_cd.model.Rastreador;

public record RastreadorExibicaoDTO(
        Long id,
        Long caminhaoId,
        String rastreador,
        String rua,
        String bairro,
        String cidade,
        String estado,
        String uf,
        String cep
) {

    public RastreadorExibicaoDTO(Rastreador rastreador) {
        this(
                rastreador.getId(),
                rastreador.getCaminhaoId(),
                rastreador.getRastreador(),
                rastreador.getRua(),
                rastreador.getBairro(),
                rastreador.getCidade(),
                rastreador.getEstado(),
                rastreador.getUf(),
                rastreador.getCep()
        );
    }

}
