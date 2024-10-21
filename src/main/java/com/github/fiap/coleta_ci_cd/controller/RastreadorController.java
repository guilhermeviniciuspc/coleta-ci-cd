package com.github.fiap.coleta_ci_cd.controller;

import com.github.fiap.coleta_ci_cd.dto.RastreadorCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.RastreadorExibicaoDTO;
import com.github.fiap.coleta_ci_cd.service.RastreadorService;
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
public class RastreadorController {

    @Autowired
    private RastreadorService rastreadorService;

    @PostMapping("/rastreador")
    @ResponseStatus(HttpStatus.CREATED)
    public RastreadorExibicaoDTO cadastrar(@RequestBody @Valid RastreadorCadastroDTO rastreador) {
        return rastreadorService.cadastrar(rastreador);
    }

    @GetMapping("/rastreador/{id}")
    public ResponseEntity<RastreadorExibicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rastreadorService.buscarPorId(id));
    }

    @GetMapping("/rastreador")
    @ResponseStatus(HttpStatus.OK)
    public Page<RastreadorExibicaoDTO> listarTodos(@PageableDefault(size = 20, page = 0) Pageable paginacao) {
        return rastreadorService.listarTodos(paginacao);
    }

    @PutMapping("/rastreador")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RastreadorExibicaoDTO> atualizar(@RequestBody RastreadorCadastroDTO rastreadorDTO) {
        RastreadorExibicaoDTO rastreadorExibicaoDTO = rastreadorService.atualizar(rastreadorDTO);
        return ResponseEntity.ok(rastreadorExibicaoDTO);
    }

    @DeleteMapping("/rastreador/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        rastreadorService.excluir(id);
    }

}
