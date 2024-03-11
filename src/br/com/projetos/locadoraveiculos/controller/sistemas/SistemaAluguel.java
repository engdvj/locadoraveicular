package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;



public class SistemaAluguel implements Alugar<Veiculo> {
    private Cadastrar<Veiculo> veiculos;
    private Cadastrar<Cliente> clientes;
    public SistemaAluguel(Cadastrar<Veiculo> veiculos, Cadastrar<Cliente> clientes) {
        this.veiculos = veiculos;
        this.clientes = clientes;
    }
    @Override
    public Cadastrar<Veiculo> obterTipo() {
        return veiculos;
    }
    @Override
    public Cadastrar<Cliente> obterClientes() {
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
