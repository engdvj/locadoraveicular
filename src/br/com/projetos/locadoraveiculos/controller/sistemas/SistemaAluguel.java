package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;

import java.util.HashSet;
import java.util.Set;

public class SistemaAluguel implements Alugar<Aluguel> {

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
    public CRUD<Veiculo> obterVeiculos() {
        CRUD<Veiculo> veiculosDisponiveis = veiculos;
         for (Veiculo veiculo : veiculos.obterLista()) {
             for (Aluguel contrato : agencia.contratos()) {
                if (contrato.veiculo().equals(veiculo)) {
                    veiculosDisponiveis.remover(veiculo);
                }
            }
        }
        return veiculosDisponiveis;
    }
    @Override
    public CRUD<Cliente> obterClientes() {
        return clientes;
    }
    @Override
    public boolean emprestar(Aluguel aluguel) {
        if(getAgencia().contratos().add(aluguel)){
            return true;
        } else{
        return false;
        }
    }
    @Override
    public boolean devolver(Aluguel aluguel) {
        return false;
    }

    public Set<Aluguel> obterContratosCliente(Cliente cliente) {
        Set<Aluguel> contratosPorCliente = new HashSet<>();
        for (Aluguel aluguel : agencia.contratos()) {
            if (aluguel.cliente().equals(cliente)) {
                contratosPorCliente.add(aluguel);
            }
        }
        return contratosPorCliente;
    }

}