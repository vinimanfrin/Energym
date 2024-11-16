package com.globalsolution.energym.domain.enums;

public enum TipoExercicio {
    BICICLETA(1,"Bicicleta"),
    ESTEIRA(2,"Esteira");

    private int cod;
    private String descricao;

    TipoExercicio(int cod, String descricao){
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

    public static TipoExercicio toEnum(Integer cod){
        for (TipoExercicio exercicio : values()){
            if (exercicio.getCod().equals(cod)) return  exercicio;
        }
        throw new IllegalArgumentException("TipoExercicio inválido: Cod:"+cod);
    }


}
