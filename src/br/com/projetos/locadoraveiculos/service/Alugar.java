package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

public interface Alugar<T>{
    Cadastrar<T> obterTipo();
    Cadastrar<Cliente> obterClientes();
    boolean emprestar(T t);
    boolean devolver(T t);
}
