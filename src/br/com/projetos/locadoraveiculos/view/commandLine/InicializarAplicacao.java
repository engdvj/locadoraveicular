package br.com.projetos.locadoraveiculos.view.commandLine;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.controller.sistemas.*;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Alugar;
import br.com.projetos.locadoraveiculos.service.CRUD;
import br.com.projetos.locadoraveiculos.service.Pagar;

import static br.com.projetos.locadoraveiculos.data.AgenciasDataLoader.loadSampleAgencia;
import static br.com.projetos.locadoraveiculos.data.ClientesDataLoader.loadSampleClientes;
import static br.com.projetos.locadoraveiculos.data.VeiculosDataLoader.loadSampleVeiculos;

public class InicializarAplicacao {

    public static ControllerLocadora inicializar() {
        Agencia agencia = loadSampleAgencia();
        CRUD<Cliente> sistemaClientes = new SistemaClientes(loadSampleClientes());
        CRUD<Veiculo> sistemaVeiculos = new SistemaVeiculos(loadSampleVeiculos());

        Alugar sistemaDeAluguel = new SistemaAluguel(agencia, sistemaVeiculos, sistemaClientes);
        Pagar sistemaDePagamento = new SistemaPagamento(agencia);
        return new ControllerLocadora(sistemaDeAluguel,sistemaDePagamento);
    }
}
