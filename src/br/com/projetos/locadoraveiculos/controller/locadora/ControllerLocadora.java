package br.com.projetos.locadoraveiculos.controller.locadora;

import br.com.projetos.locadoraveiculos.controller.sistemas.SistemaPagamento;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.model.eventos.Pagamento;
import br.com.projetos.locadoraveiculos.service.Alugar;
import br.com.projetos.locadoraveiculos.service.Pagar;

public class ControllerLocadora {
    private Pagar sistemaDePagamento;
    private Alugar<Veiculo> sistemaDeAluguel;
    public ControllerLocadora(Alugar alugarCarros,Pagar sistemaDePagamento) {
        this.sistemaDePagamento = sistemaDePagamento;
        this.sistemaDeAluguel = alugarCarros;
    }
    public Alugar<Veiculo> getSistemaDeAluguel() {
        return sistemaDeAluguel;
    }

    public Pagar getSistemaDePagamento() {
        return sistemaDePagamento;
    }
}