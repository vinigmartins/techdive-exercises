package com.example.listacompras.model;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

public class Item {

    @NotNull(message = "{campo.obrigatorio}")
    private String nome;

    private Float quantidade;

    private String medida;

    public Item() {
    }

    public Item(String nome, Float quantidade, String medida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    private final List<String> medidas = Arrays.asList("unidades", "kilos", "litros", "garafas", "pacotes");

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List<String> getMedidas() {
        return medidas;
    }

    @Override
    public String toString() {
        return quantidade + " " + medida + " de " + nome;
    }
}
