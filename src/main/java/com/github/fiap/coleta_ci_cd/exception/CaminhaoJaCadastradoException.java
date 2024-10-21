package com.github.fiap.coleta_ci_cd.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class CaminhaoJaCadastradoException extends DataIntegrityViolationException {

    public CaminhaoJaCadastradoException(String mensagem) {
        super(mensagem);
    }

}
