package com.globalsolution.energym.domain.entities;

import com.globalsolution.energym.domain.enums.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "praticantes")
public class Praticante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "praticante")
    private List<Exercicio> exercicios;

    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private double pontos;
    private Integer sexo;

    public Praticante() {
    }

    public Praticante(Long id,String cpf, String email, LocalDate dataNascimento, double pontos, Integer sexo) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.pontos = pontos;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public Sexo getSexo() {
        return Sexo.toEnum(sexo);
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo.getCod();
    }
}
