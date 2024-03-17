package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;

import java.time.*;
import java.util.*;


import static br.com.projetos.locadoraveiculos.data.ClientesDataLoader.*;
import static br.com.projetos.locadoraveiculos.data.VeiculosDataLoader.*;


public class ContratosDataLoader {
    public static HashSet<Aluguel> loadSampleContratos() {
        HashSet<Veiculo> veiculos = loadSampleVeiculos();
        HashSet<Cliente> clientes = loadSampleClientes();

        HashSet<Aluguel> contratosAtivos = new HashSet<>();
        HashSet<Devolucao> contratosInativos = new HashSet<>();

        Iterator<Veiculo> veiculoIterator = veiculos.iterator();
        Iterator<Cliente> clienteIterator = clientes.iterator();

        int index = 0;
        while (veiculoIterator.hasNext() && clienteIterator.hasNext() && index < veiculos.size() && index < clientes.size()) {
            LocalDateTime dataEvento = LocalDateTime.of(2024, Month.MARCH, 10 + index, 10 + (index % 4), 0);
            Aluguel aluguel = new Aluguel(veiculoIterator.next(), clienteIterator.next(), dataEvento);
            contratosAtivos.add(aluguel);

            // Decide aleatoriamente quais contratos serão marcados como inativos
            if (index % 2 == 0 && contratosInativos.size() < 3) { // Exemplo: marca cada segundo contrato como inativo até ter 3
                LocalDateTime dataDevolucao = dataEvento.plusDays(5); // Simula a devolução 5 dias após o aluguel
                Devolucao devolucao = new Devolucao(aluguel, dataDevolucao);
                contratosInativos.add(devolucao);
                contratosAtivos.remove(aluguel);
            }

            index++;
        }

        // Opcional: Imprime os contratos para verificação
        System.out.println("---------------Contratos Ativos---------------");
        for (Aluguel aluguel : contratosAtivos) {
            System.out.println(aluguel);
        }

        System.out.println("---------------Contratos Inativos---------------");
        for (Devolucao devolucao : contratosInativos) {
            System.out.println(devolucao);
        }

        // Assumindo que você tem métodos para adicionar esses contratos ao sistema
        // Adicione os contratos ativos e inativos ao sistema aqui
        return contratosAtivos;
    }
}
