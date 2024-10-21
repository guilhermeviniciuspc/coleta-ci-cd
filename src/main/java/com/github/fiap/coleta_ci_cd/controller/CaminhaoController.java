package com.github.fiap.coleta_ci_cd.controller;

import com.github.fiap.coleta_ci_cd.dto.CaminhaoCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.CaminhaoExibicaoDTO;
import com.github.fiap.coleta_ci_cd.service.CaminhaoService;
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
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoExibicaoDTO cadastrar(@RequestBody @Valid CaminhaoCadastroDTO caminhao) {
        return caminhaoService.cadastrar(caminhao);
    }

    @GetMapping("/caminhao/{id}")
    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caminhaoService.buscarPorId(id));
    }

    @GetMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public Page<CaminhaoExibicaoDTO> listarTodos(@PageableDefault(size = 20, page = 0) Pageable paginacao) {
        return caminhaoService.listarTodos(paginacao);
    }

    @PutMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CaminhaoExibicaoDTO> atualizar(@RequestBody CaminhaoCadastroDTO caminhaoDTO) {
        CaminhaoExibicaoDTO caminhaoExibicaoDTO = caminhaoService.atualizar(caminhaoDTO);
        return ResponseEntity.ok(caminhaoExibicaoDTO);
    }

    @DeleteMapping("/caminhao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        caminhaoService.excluir(id);
    }

}
