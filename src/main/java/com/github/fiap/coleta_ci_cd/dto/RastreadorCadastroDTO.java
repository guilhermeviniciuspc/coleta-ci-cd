package com.github.fiap.coleta_ci_cd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RastreadorCadastroDTO(
        Long id,
        @NotNull(message = "O código do caminhão é obrigatório!")
        Long caminhaoId,
        @NotBlank(message = "A descrição do rastreador é obrigatória!")
        String rastreador,
        @NotBlank(message = "O nome da rua é obrigatório!")
        String rua,
        @NotBlank(message = "O nome do bairro é obrigatório!")
        String bairro,
        @NotBlank(message = "O nome da cidade é obrigatória!")
        String cidade,
        @NotBlank(message = "O nome do estado é obrigatório!")
        String estado,
        @NotBlank(message = "A sigla UF é obrigatória!")
        String uf,
        @NotBlank(message = "O cep é obrigatório!")
        String cep
) {
}