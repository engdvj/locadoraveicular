package br.com.projetos.locadoraveiculos.controller.locadora;

import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Alugar;

public class ControllerLocadora {
    private Alugar<Veiculo> sistemaDeAluguel;
    public ControllerLocadora(Alugar alugarCarros) {
        this.sistemaDeAluguel = alugarCarros;
    }
    public Alugar<Veiculo> getSistemaDeAluguel() {
        return sistemaDeAluguel;
    }
}