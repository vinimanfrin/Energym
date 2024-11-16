package com.globalsolution.energym.domain.enums;

public enum Sexo {
    MASCULINO(1,"Masculino"),
    FEMININO(2,"Feminino");

    private Integer cod;
    private String descricao;

    Sexo(Integer cod,String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Sexo toEnum(Integer cod){
        for (Sexo sexo : values()){
            if (sexo.getCod().equals(cod)) return sexo;
        }
        throw new IllegalArgumentException("Sexo inválido: Cod:"+cod);
    }
}
