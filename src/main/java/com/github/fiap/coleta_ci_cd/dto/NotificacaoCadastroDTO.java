package com.github.fiap.coleta_ci_cd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NotificacaoCadastroDTO(
        Long id,
        @NotNull(message = "O ID da rota é obrigatório!")
        Long rotaId,
        @NotNull(message = "O ID do caminhão é obrigatório!")
        Long caminhaoId,
        @NotBlank(message = "A mensagem é obrigatória!")
        String mensagem,
        @NotNull(message = "A data de envio é obrigatória!")
        LocalDate dataEnvio
) {
}
