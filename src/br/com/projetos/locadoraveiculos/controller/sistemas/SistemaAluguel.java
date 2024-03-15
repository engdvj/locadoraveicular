package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;

public class SistemaAluguel implements Alugar<Veiculo> {
    private Agencia agencia;
    private CRUD<Veiculo> veiculos;
    private CRUD<Cliente> clientes;
    public SistemaAluguel(Agencia agencia, CRUD<Veiculo> veiculos, CRUD<Cliente> clientes) {
        this.agencia = agencia;
        this.veiculos = veiculos;
        this.clientes = clientes;
    }
    @Override
    public Agencia getAgencia(){
        return this.agencia;
    }
    @Override
    public CRUD<Veiculo> obterTipo() {
        return veiculos;
    }
    @Override
    public CRUD<Cliente> obterClientes() {
        return clientes;
    }
    @Override
    public boolean emprestar(Veiculo veiculo) { return false; }
    @Override
    public boolean devolver(Veiculo veiculo) {
        return false;
    }

}
