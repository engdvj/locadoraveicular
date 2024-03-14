package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

public interface Alugar<T>{
    CRUD<T> obterTipo();
    CRUD<Cliente> obterClientes();
    boolean emprestar(T t);
    boolean devolver(T t);
}
