package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.*;

import java.util.HashSet;

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
        return veiculos;
    }
    public CRUD<Veiculo> obterVeiculosDisponiveis() {
        CRUD<Veiculo> veiculosDisponiveis;
        return veiculos;
    }

    @Override
    public CRUD<Cliente> obterClientes() {
        return clientes;
    }
    @Override
    public boolean emprestar(Aluguel aluguel) {
        if(getAgencia().contratos().add(aluguel)){
            return true;
        }else{
        return false;
        }
    }
    @Override
    public boolean devolver(Aluguel aluguel) {
        return false;
    }

}