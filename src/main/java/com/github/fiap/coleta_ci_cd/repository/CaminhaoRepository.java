package com.github.fiap.coleta_ci_cd.repository;

import com.github.fiap.coleta_ci_cd.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    Boolean existsByPlaca(String placa);

    Boolean existsByRenavam(Long renavam);

    Boolean existsByChassi(String chassi);

}
