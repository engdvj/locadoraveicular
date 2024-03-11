package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.controller.sistemas.*;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;

public interface Alugar{
    SistemaVeiculos obterVeiculos();
    SistemaClientes obterClientes();
    boolean emprestar(Veiculo veiculo);
    boolean devolver(Veiculo veiculo);
}
