package br.com.projetos.locadoraveiculos.model.eventos;

import br.com.projetos.locadoraveiculos.service.Listar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Devolucao(Aluguel aluguel, LocalDateTime dataDevolucao) implements Listar {

    @Override
    public String obterNomeOrganizado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return new StringBuilder()
                .append("Detalhes da Devolucao:\n")
                .append("Veículo: ")
                .append(aluguel.veiculo().getMarca())
                .append(" ")
                .append(aluguel.veiculo().getModelo())
                .append(" - Placa: ")
                .append(aluguel.veiculo().getPlaca())
                .append("\nCliente: ")
                .append(aluguel.cliente().obterNomeOrganizado()) // assumindo que Cliente tem um método obterNomeOrganizado
                .append(" - Documento: ")
                .append(aluguel.cliente().getDocumento()) // assegure-se de que este método esteja disponível em Cliente
                .append("\nData do Aluguel: ")
                .append(aluguel.dataAluguel().format(formatter))
                .append("\nData da Devolucao: \"")
                .append(dataDevolucao().format(formatter))
                .append("\n\n")
                .toString();
    }
    @Override
    public String toString() {
        return obterNomeOrganizado();
    }
}
