package br.com.projetos.locadoraveiculos.model.eventos;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Listar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Aluguel (Veiculo veiculo, Cliente cliente, LocalDateTime dataRetirada,String endereco) implements Listar {

    @Override
    public String obterNomeOrganizado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return new StringBuilder()
                .append("Detalhes do Aluguel:\n")
                .append("Endereço para a coleta: ")
                .append(endereco)
                .append("\nVeículo: ")
                .append(veiculo.getMarca())
                .append(" ")
                .append(veiculo.getModelo())
                .append(" - Placa: ")
                .append(veiculo.getPlaca())
                .append("\nCliente: ")
                .append(cliente.obterNomeOrganizado()) // assumindo que Cliente tem um método obterNomeOrganizado
                .append(" - Documento: ")
                .append(cliente.getDocumento()) // assegure-se de que este método esteja disponível em Cliente
                .append("\nData do Aluguel: ")
                .append(dataRetirada.format(formatter)).append("\n\n")
                .toString();
    }
    @Override
    public String toString() {
        return obterNomeOrganizado();
    }
}
