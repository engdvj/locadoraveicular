package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;

public class SistemaAluguel implements Alugar<Veiculo> {
    private CRUD<Veiculo> veiculos;
    private CRUD<Cliente> clientes;
    public SistemaAluguel(CRUD<Veiculo> veiculos, CRUD<Cliente> clientes) {
        this.veiculos = veiculos;
        this.clientes = clientes;
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
    public boolean emprestar(Veiculo veiculo) {
        return false;
    }
    @Override
    public boolean devolver(Veiculo veiculo) {
        return false;
    }

}
