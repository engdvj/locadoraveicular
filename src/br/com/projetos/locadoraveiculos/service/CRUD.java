package br.com.projetos.locadoraveiculos.service;

import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public interface CRUD<T>{
    boolean add(T item);
    T editar(T item,T newItem);
    T realizarBusca(String nome);
    boolean remover(T item);
    TreeSet<T> obterTipo();
}
