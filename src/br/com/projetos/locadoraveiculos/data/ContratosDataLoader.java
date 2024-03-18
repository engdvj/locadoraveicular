package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static br.com.projetos.locadoraveiculos.data.ClientesDataLoader.loadSampleClientes;
import static br.com.projetos.locadoraveiculos.data.VeiculosDataLoader.loadSampleVeiculos;

public class ContratosDataLoader {

    public ResultadoContratos processarContratos(String endereco) {
        HashSet<Aluguel> contratosAtivos = criarContratosAtivos(endereco);
        HashSet<Devolucao> contratosInativos = inativarContratos(contratosAtivos);
        imprimirContratos(contratosAtivos, contratosInativos);

        return new ResultadoContratos(contratosAtivos, contratosInativos);
    }

    private HashSet<Aluguel> criarContratosAtivos(String endereco) {
        HashSet<Veiculo> veiculos = loadSampleVeiculos();
        HashSet<Cliente> clientes = loadSampleClientes();

        HashSet<Aluguel> contratosAtivos = new HashSet<>();
        Iterator<Veiculo> veiculoIterator = veiculos.iterator();
        Iterator<Cliente> clienteIterator = clientes.iterator();

        int index = 0;
        while (veiculoIterator.hasNext() && clienteIterator.hasNext()) {
            LocalDateTime dataEvento = LocalDateTime.of(2024, Month.MARCH, 10 + index, 10 + (index % 4), 0);
            Aluguel aluguel = new Aluguel(veiculoIterator.next(), clienteIterator.next(), dataEvento, endereco);
            contratosAtivos.add(aluguel);
            index++;
        }

        return contratosAtivos;
    }

    private HashSet<Devolucao> inativarContratos(HashSet<Aluguel> contratosAtivos) {
        HashSet<Devolucao> contratosInativos = new HashSet<>();
        List<Aluguel> contratosList = new ArrayList<>(contratosAtivos);
        Collections.shuffle(contratosList);

        for (int i = 0; i < contratosList.size() && contratosInativos.size() < 3; i++) {
            Aluguel aluguel = contratosList.get(i);
            if (i % 2 == 0) {
                LocalDateTime dataDevolucao = aluguel.dataRetirada().plusDays(5);
                Devolucao devolucao = new Devolucao(aluguel, dataDevolucao);
                contratosInativos.add(devolucao);
                contratosAtivos.remove(aluguel);
            }
        }

        return contratosInativos;
    }

    private void imprimirContratos(HashSet<Aluguel> contratosAtivos, HashSet<Devolucao> contratosInativos) {
        System.out.println("---------------Contratos Ativos---------------");
        for (Aluguel aluguel : contratosAtivos) {
            System.out.println(aluguel);
        }

        System.out.println("---------------Contratos Inativos---------------");
        for (Devolucao devolucao : contratosInativos) {
            System.out.println(devolucao);
        }
    }

    public static class ResultadoContratos {
        private HashSet<Aluguel> contratosAtivos;
        private HashSet<Devolucao> contratosInativos;

        public ResultadoContratos(HashSet<Aluguel> contratosAtivos, HashSet<Devolucao> contratosInativos) {
            this.contratosAtivos = contratosAtivos;
            this.contratosInativos = contratosInativos;
        }

        public HashSet<Aluguel> getContratosAtivos() {
            return contratosAtivos;
        }

        public HashSet<Devolucao> getContratosInativos() {
            return contratosInativos;
        }
    }
}