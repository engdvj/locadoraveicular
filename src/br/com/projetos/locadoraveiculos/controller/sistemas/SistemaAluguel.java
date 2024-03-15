package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.agencia.AgenciaAluguel;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SistemaAluguel implements Alugar<Cliente, Veiculo, AgenciaAluguel> {
    private CRUD<Veiculo> veiculos;
    private CRUD<Cliente> clientes;
    private CRUD<AgenciaAluguel> agencias;
    public SistemaAluguel(CRUD<Veiculo> veiculos, CRUD<Cliente> clientes, CRUD<AgenciaAluguel> agencias) {
        this.veiculos = veiculos;
        this.clientes = clientes;
        this.agencias = agencias;

    }

    @Override
    public CRUD<Cliente> obterTipo() {
        return null;
    }
    @Override
    public CRUD<Cliente> obterClientes() {
        return clientes;
    }
    @Override
    public boolean alugar(Cliente cliente, Veiculo veiculo, AgenciaAluguel agenciaAluguel, LocalDateTime horarioRetirada) {
        return true;
    }
    @Override
    public boolean devolver (Cliente cliente, Veiculo veiculo, AgenciaAluguel agenciaAluguel, LocalDateTime horarioDevolucao) {
        return false;
    }

}
