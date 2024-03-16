package br.com.projetos.locadoraveiculos.service;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;

import java.util.Set;

public interface Alugar<T>{
    Agencia getAgencia();
    CRUD<Veiculo> obterVeiculos();
    CRUD<T> obterTipo();
    CRUD<Cliente> obterClientes();
    Set<Aluguel> obterContratosCliente(Cliente cliente);
    boolean emprestar(Aluguel aluguel);
    boolean devolver(Aluguel aluguel);
}