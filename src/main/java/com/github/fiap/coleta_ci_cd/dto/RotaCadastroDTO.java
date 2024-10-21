package com.github.fiap.coleta_ci_cd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RotaCadastroDTO(
        Long id,
        @NotNull(message = "O código do caminhão é obrigatório!")
        Long caminhaoId,
        @NotNull(message = "A data de agendamento é obrigatória!")
        LocalDate dataAgendamento,
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
