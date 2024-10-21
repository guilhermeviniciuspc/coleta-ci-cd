package com.github.fiap.coleta_ci_cd.controller;

import com.github.fiap.coleta_ci_cd.dto.RotaCadastroDTO;
import com.github.fiap.coleta_ci_cd.dto.RotaExibicaoDTO;
import com.github.fiap.coleta_ci_cd.service.RotaService;
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
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @PostMapping("/rota")
    @ResponseStatus(HttpStatus.CREATED)
    public RotaExibicaoDTO cadastrar(@RequestBody @Valid RotaCadastroDTO rota) {
        return rotaService.cadastrar(rota);
    }

    @GetMapping("/rota/{id}")
    public ResponseEntity<RotaExibicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rotaService.buscarPorId(id));
    }

    @GetMapping("/rota")
    @ResponseStatus(HttpStatus.OK)
    public Page<RotaExibicaoDTO> listarTodas(@PageableDefault(size = 20, page = 0) Pageable paginacao) {
        return rotaService.listarTodas(paginacao);
    }

    @PutMapping("/rota")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RotaExibicaoDTO> atualizar(@RequestBody RotaCadastroDTO rotaDTO) {
        RotaExibicaoDTO rotaExibicaoDTO = rotaService.atualizar(rotaDTO);
        return ResponseEntity.ok(rotaExibicaoDTO);
    }

    @DeleteMapping("/rota/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        rotaService.excluir(id);
    }

}
