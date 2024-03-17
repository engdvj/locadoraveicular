package br.com.projetos.locadoraveiculos.model.eventos;

import br.com.projetos.locadoraveiculos.service.Listar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Pagamento(Devolucao devolucao, LocalDateTime dataDevolucao) implements Listar {

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
