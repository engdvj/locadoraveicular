package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.event.Aluguel;
import br.com.projetos.locadoraveiculos.model.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;

public interface Alugar<T>{
    Agencia getAgencia();
    CRUD<Veiculo> obterVeiculos();
    CRUD<Cliente> obterClientes();
    boolean emprestar(Aluguel aluguel);
    boolean devolver(T t);
}