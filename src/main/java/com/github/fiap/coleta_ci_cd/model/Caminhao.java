package com.github.fiap.coleta_ci_cd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "t_caminhao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_caminhao")
    private Long id;

    @NotBlank
    @Column(name = "ds_caminhao")
    private String caminhao;

    @NotBlank
    @Column(name = "ds_placa")
    private String placa;

    @NotNull
    @Column(name = "ds_renavam")
    private Long renavam;

    @NotBlank
    @Column(name = "ds_chassi")
    private String chassi;

    @NotNull
    @Column(name = "dt_ano_fabricacao")
    private Integer dataAnoFabricacao;

    @NotNull
    @Column(name = "dt_ano_modelo")
    private Integer dataAnoModelo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(String caminhao) {
        this.caminhao = caminhao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getRenavam() {
        return renavam;
    }

    public void setRenavam(Long renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getDataAnoFabricacao() {
        return dataAnoFabricacao;
    }

    public void setDataAnoFabricacao(Integer dataAnoFabricacao) {
        this.dataAnoFabricacao = dataAnoFabricacao;
    }

    public Integer getDataAnoModelo() {
        return dataAnoModelo;
    }

    public void setDataAnoModelo(Integer dataAnoModelo) {
        this.dataAnoModelo = dataAnoModelo;
    }

}