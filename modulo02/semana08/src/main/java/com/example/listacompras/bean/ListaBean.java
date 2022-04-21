package com.example.listacompras.bean;

import com.example.listacompras.model.Item;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SessionScoped
@Named("listaBean")
public class ListaBean implements Serializable {

    private Item item = new Item();

    private List<Item> lista = new ArrayList<>();

    private List<Item> itensSelecionados = new ArrayList<>();

    public void adicionarNaLista() {
        this.lista.add(item);
        item = new Item();
    }

    public void removerDaLista() {
        this.lista.removeAll(this.itensSelecionados);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getLista() {
        return lista;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }

    public List<Item> getItensSelecionados() {
        return itensSelecionados;
    }

    public void setItensSelecionados(List<Item> itensSelecionados) {
        this.itensSelecionados = itensSelecionados;
    }
}
