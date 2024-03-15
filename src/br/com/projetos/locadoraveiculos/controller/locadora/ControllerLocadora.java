package br.com.projetos.locadoraveiculos.controller.locadora;

import br.com.projetos.locadoraveiculos.model.agencia.AgenciaAluguel;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Alugar;
import br.com.projetos.locadoraveiculos.service.CRUD;

public class ControllerLocadora {

    private String nome;
    private CRUD<Veiculo> sistemaDeCarros;
    private CRUD<Cliente> sistemaDeClientes;
    private CRUD<AgenciaAluguel> sistemDeAgencias;
    private Alugar<Cliente, Veiculo, AgenciaAluguel> sistemaDeAluguel;
    public ControllerLocadora(String nome, Alugar alugarCarros) {
        this.nome = nome;
        this.sistemaDeAluguel = alugarCarros;
        this.sistemaDeCarros =  alugarCarros.obterTipo();
        this.sistemaDeClientes = alugarCarros.obterClientes();
        this.sistemDeAgencias = alugarCarros.obterAgencias();
    }
    public String getNome() {
        return nome;
    }
    public CRUD<Cliente> getSistemaDeClientes() {
        return sistemaDeClientes;
    }
    public CRUD<Veiculo> getSistemaDeCarros() {
        return sistemaDeCarros;
    }
    public CRUD<AgenciaAluguel> getSistemDeAgencias() {return sistemDeAgencias; }
    public Alugar<Cliente, Veiculo, AgenciaAluguel> getSistemaDeAluguel() {
        return sistemaDeAluguel;
    }
}
