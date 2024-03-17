package br.com.projetos.locadoraveiculos.model.eventos;

import br.com.projetos.locadoraveiculos.service.Listar;


public record Pagamento(Devolucao devolucao) implements Listar {

    @Override
    public String obterNomeOrganizado() {
        return new StringBuilder()
                .append("Quantidade de Diárias:\n")
//                .append()
                .append("Valor da Diária: \n")
//                .append()
                .append("Valor do Desconto: \n")
//                .append()
                .append("Valor Total: \n")
//                .append()
                .append("\n\n")
                .toString();
    }
    @Override
    public String toString() {
        return obterNomeOrganizado();
    }
}
