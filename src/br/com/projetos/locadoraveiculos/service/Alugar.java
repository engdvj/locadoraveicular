package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;

public interface Alugar<T>{
    Agencia getAgencia();
    CRUD<Veiculo> obterVeiculos();
    CRUD<Cliente> obterClientes();
    boolean emprestar(T t);
    boolean devolver(T t);
}