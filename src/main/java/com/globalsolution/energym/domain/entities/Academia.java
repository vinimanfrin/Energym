package com.globalsolution.energym.domain.entities;

import com.globalsolution.energym.dto.AcademiaCreateDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "academias")
public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String nome;

    @OneToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "academia")
    private List<Exercicio> exercicios;

    public Academia() {
    }

    public Academia(Long id, String cnpj, String nome, User user, Endereco endereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.user = user;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void updateData(AcademiaCreateDTO academiaCreateDTO) {
        this.cnpj = academiaCreateDTO.getCnpj();
        this.nome = academiaCreateDTO.getNome();
    }
}
