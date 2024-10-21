package com.github.fiap.coleta_ci_cd.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaminhaoCadastroDTO(
        Long id,
        @NotBlank(message = "A descrição do caminhão é obrigatória!")
        String caminhao,
        @NotBlank(message = "A placa do caminhão é obrigatória!")
        String placa,
        @NotNull(message = "O renavam do caminhão é obrigatório")
        Long renavam,
        @NotBlank(message = "O chassi do caminhão é obrigatório")
        String chassi,
        @NotNull(message = "O ano de fabricação é obrigatório")
        Integer dataAnoFabricacao,
        @NotNull(message = "O ano do modelo é obrigatório")
        Integer dataAnoModelo
) {
}