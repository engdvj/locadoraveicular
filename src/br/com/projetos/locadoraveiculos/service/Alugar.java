package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

public interface Alugar<T>{
    Agencia getAgencia();
    CRUD<T> obterTipo();
    CRUD<Cliente> obterClientes();
    boolean emprestar(T t);
    boolean devolver(T t);
}
