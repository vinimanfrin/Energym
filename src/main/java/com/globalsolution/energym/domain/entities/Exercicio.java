package com.globalsolution.energym.domain.entities;

import com.globalsolution.energym.domain.enums.TipoExercicio;
import jakarta.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Academia academia;

    @ManyToOne
    private Praticante praticante;

    private Integer tipo;

    private double km;

    private double pontos;

    public Exercicio() {
    }

    public Exercicio(Long id, Academia academia, Integer tipo, double km, double pontos, Praticante praticante) {
        this.id = id;
        this.academia = academia;
        this.tipo = tipo;
        this.km = km;
        this.pontos = pontos;
        this.praticante = praticante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public TipoExercicio getTipo() {
        return TipoExercicio.toEnum(tipo);
    }

    public void setTipo(TipoExercicio tipo) {
        this.tipo = tipo.getCod();
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Praticante getPraticante() {
        return praticante;
    }

    public void setPraticante(Praticante praticante) {
        this.praticante = praticante;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
}
