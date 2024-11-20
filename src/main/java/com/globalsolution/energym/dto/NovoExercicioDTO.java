package com.globalsolution.energym.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class NovoExercicioDTO {

    @NotNull private Long academiaId;
    @NotNull private Long praticanteId;
    @NotNull private Integer tipo;
    @NotNull @Min(1) private double km;

    public NovoExercicioDTO() {
    }

    public NovoExercicioDTO(Long academiaId, Long praticanteId, Integer tipo, double km) {
        this.academiaId = academiaId;
        this.praticanteId = praticanteId;
        this.tipo = tipo;
        this.km = km;
    }

    public Long getAcademiaId() {
        return academiaId;
    }

    public void setAcademiaId(Long academiaId) {
        this.academiaId = academiaId;
    }

    public Long getPraticanteId() {
        return praticanteId;
    }

    public void setPraticanteId(Long praticanteId) {
        this.praticanteId = praticanteId;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
