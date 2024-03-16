package br.com.projetos.locadoraveiculos.service;

import java.util.TreeSet;

public interface CRUD<T>{
    boolean add(T item);
    T editar(T item,T newItem);
    T realizarBusca(String nome);
    boolean remover(T item);
    TreeSet<T> obterLista();
}
