package com.github.fiap.coleta_ci_cd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "t_rastreador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rastreador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_rastreador")
    private Long id;

    @NotNull
    @Column(name = "cd_caminhao")
    private Long caminhaoId;

    @NotBlank
    @Column(name = "ds_rastreador")
    private String rastreador;

    @NotBlank
    @Column(name = "ds_rua")
    private String rua;

    @NotBlank
    @Column(name = "ds_bairro")
    private String bairro;

    @NotBlank
    @Column(name = "ds_cidade")
    private String cidade;

    @NotBlank
    @Column(name = "ds_estado")
    private String estado;

    @NotBlank
    @Column(name = "ds_uf")
    private String uf;

    @NotBlank
    @Column(name = "ds_cep")
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaminhaoId() {
        return caminhaoId;
    }

    public void setCaminhaoId(Long caminhaoId) {
        this.caminhaoId = caminhaoId;
    }

    public String getRastreador() {
        return rastreador;
    }

    public void setRastreador(String rastreador) {
        this.rastreador = rastreador;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}