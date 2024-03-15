package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.agencia.AgenciaAluguel;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Alugar<T, S, U>{
    CRUD<T> obterTipo();
    CRUD<Cliente> obterClientes();

    CRUD<AgenciaAluguel> obterAgencias();

    boolean alugar(T x, S y, U z, LocalDateTime horarioRetirada);
    boolean devolver(T x, S y, U z, LocalDateTime horarioDevolucao);
}
