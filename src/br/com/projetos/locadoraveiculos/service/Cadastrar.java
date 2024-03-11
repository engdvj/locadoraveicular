package br.com.projetos.locadoraveiculos.service;

public interface Cadastrar <T>{
    boolean add(T item);
    T editar(T item,T newItem);
    T realizarBusca(String nome);
    boolean remover(T item);
}
