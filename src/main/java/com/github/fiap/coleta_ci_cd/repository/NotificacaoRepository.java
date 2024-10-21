package com.github.fiap.coleta_ci_cd.repository;

import com.github.fiap.coleta_ci_cd.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

}
