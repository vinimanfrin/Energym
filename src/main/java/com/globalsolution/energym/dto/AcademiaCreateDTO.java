package com.globalsolution.energym.dto;

import com.globalsolution.energym.domain.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

public class AcademiaCreateDTO {

    @CNPJ
    @NotBlank
    private String cnpj;

    @NotBlank
    @Pattern(regexp = "^.{3,}$",message = "Nome não pode ser muito curto")
    private String nome;

    @Valid
    private EnderecoCreateDTO endereco;

    private User user;

    public AcademiaCreateDTO() {
    }

    public AcademiaCreateDTO(String cnpj, String nome, EnderecoCreateDTO endereco,User user) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.user = user;
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

    public EnderecoCreateDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCreateDTO endereco) {
        this.endereco = endereco;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
