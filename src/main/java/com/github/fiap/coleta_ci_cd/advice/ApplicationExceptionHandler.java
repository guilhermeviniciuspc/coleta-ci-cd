package com.github.fiap.coleta_ci_cd.advice;

import com.github.fiap.coleta_ci_cd.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {

        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for(FieldError campo : campos ) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }

        return errorMap;

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CaminhaoNaoEncontradoException.class)
    public Map<String, String> handleCaminhaoNaoEncontrado() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Caminhão não encontrado!");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CaminhaoJaCadastradoException.class)
    public Map<String, String> handleCaminhaoJaCadastrado() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Caminhão já cadastrado!");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RastreadorNaoEncontradoException.class)
    public Map<String, String> handleRastreadorNaoEncontrado() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Rastreador não encontrado!");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RotaNaoEncontradaException.class)
    public Map<String, String> handleRotaNaoEncontrada() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Rota não encontrada!");

        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotificacaoNaoEncontradaException.class)
    public Map<String, String> handleNotificacaoNaoEncontrada() {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Notificação não encontrada!");

        return errorMap;
    }

}
