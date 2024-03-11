package br.com.projetos.locadoraveiculos.controller.locadora;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Alugar;
import br.com.projetos.locadoraveiculos.service.Cadastrar;

public class ControllerLocadora {

    private String nome;
    private Cadastrar<Veiculo> sistemaDeCarros;
    private Cadastrar<Cliente> sistemaDeClientes;
    private Alugar<Veiculo> sistemaDeAluguel;
    public ControllerLocadora(String nome, Alugar alugarCarros) {
        this.nome = nome;
        this.sistemaDeAluguel = alugarCarros;
        this.sistemaDeCarros =  alugarCarros.obterTipo();
        this.sistemaDeClientes = alugarCarros.obterClientes();
    }
    public String getNome() {
        return nome;
    }
    public Cadastrar<Cliente> getSistemaDeClientes() {
        return sistemaDeClientes;
    }
    public Cadastrar<Veiculo> getSistemaDeCarros() {
        return sistemaDeCarros;
    }
    public Alugar<Veiculo> getSistemaDeAluguel() {
        return sistemaDeAluguel;
    }
}
