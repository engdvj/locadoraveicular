package br.com.projetos.locadoraveiculos.service;

import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.model.eventos.Pagamento;

public interface Pagar {

    double calcularPagamento(Devolucao devolucao);
    void imprimirRecido(Pagamento pagamento);
}
