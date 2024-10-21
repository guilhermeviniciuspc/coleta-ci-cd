package com.github.fiap.coleta_ci_cd.controller;

import com.github.fiap.coleta_ci_cd.dto.NotificacaoCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.NotificacaoExibicaoDTO;
import com.github.fiap.coleta_ci_cd.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/notificacao")
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacaoExibicaoDTO cadastrar(@RequestBody @Valid NotificacaoCadastroDTO notificacao) {
        return notificacaoService.cadastrar(notificacao);
    }

    @GetMapping("/notificacao/{id}")
    public ResponseEntity<NotificacaoExibicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notificacaoService.buscarPorId(id));
    }

    @GetMapping("/notificacao")
    @ResponseStatus(HttpStatus.OK)
    public Page<NotificacaoExibicaoDTO> listarTodos(@PageableDefault(size = 20, page = 0) Pageable paginacao) {
        return notificacaoService.listarTodas(paginacao);
    }

    @PutMapping("/notificacao")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NotificacaoExibicaoDTO> atualizar(@RequestBody NotificacaoCadastroDTO notificacaoDTO) {
        NotificacaoExibicaoDTO notificacaoExibicaoDTO = notificacaoService.atualizar(notificacaoDTO);
        return ResponseEntity.ok(notificacaoExibicaoDTO);
    }

    @DeleteMapping("/notificacao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        notificacaoService.excluir(id);
    }

}
