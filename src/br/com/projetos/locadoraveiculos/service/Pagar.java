package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.model.eventos.Pagamento;

import java.util.ArrayList;

public interface Pagar {

    ArrayList<Double> calcularPagamento(Devolucao devolucao);
    void imprimirRecido(ArrayList<Double> dadosPagamento);
}
