package br.com.projetos.locadoraveiculos.controller.locadora;

import br.com.projetos.locadoraveiculos.controller.sistemas.SistemaClientes;
import br.com.projetos.locadoraveiculos.controller.sistemas.SistemaVeiculos;
import br.com.projetos.locadoraveiculos.service.Alugar;

public class ControllerLocadora {

    private String nome;
    private SistemaVeiculos sistemaDeCarros;
    private SistemaClientes sistemaDeClientes;
    private Alugar sistemaDeAluguel;
    public ControllerLocadora(String nome, Alugar alugarCarros) {
        this.nome = nome;
        this.sistemaDeAluguel = alugarCarros;
        this.sistemaDeCarros =  alugarCarros.obterVeiculos();
        this.sistemaDeClientes = alugarCarros.obterClientes();
    }

    public String getNome() {
        return nome;
    }

    public SistemaVeiculos getSistemaDeCarros() {
        return sistemaDeCarros;
    }

    public SistemaClientes getSistemaDeClientes() {
        return sistemaDeClientes;
    }

    public Alugar getSistemaDeAluguel() {
        return sistemaDeAluguel;
    }
}
