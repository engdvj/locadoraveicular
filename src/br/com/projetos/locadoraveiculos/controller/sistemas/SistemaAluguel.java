package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Alugar;


public class SistemaAluguel implements Alugar {
    private SistemaVeiculos veiculos;
    private SistemaClientes clientes;
    public SistemaAluguel(SistemaVeiculos veiculos, SistemaClientes clientes) {
        this.veiculos = veiculos;
        this.clientes = clientes;
    }
    @Override
    public SistemaVeiculos obterVeiculos() {
        return veiculos;
    }
    @Override
    public SistemaClientes obterClientes() {
        return clientes;
    }
    @Override
    public boolean emprestar(Veiculo item) {
        return false;
    }
    @Override
    public boolean devolver(Veiculo item) {
        return false;
    }
}
