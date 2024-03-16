package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Set;


import static br.com.projetos.locadoraveiculos.view.commandLine.App.*;

import static br.com.projetos.locadoraveiculos.view.commandLine.App.*;

public class MenuAluguel implements Apresentar {
    private final ControllerLocadora controller;
    public MenuAluguel(ControllerLocadora controller) {
        this.controller = controller;
    }
    @Override
    public void escolherOpcao() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    Escolha uma opção abaixo:
                     (1) - Alugar um veículo
                     (2) - Devolver um veículo
                     (3) - Ver informações
                     (4) - Voltar ao Menu Anterior
                    """);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    alugarVeiculo();
                    break;
                case "2":
                    devolverVeiculo();
                    break;
                case "3":
                    verInformacoes();
                    break;
                case "4":
                    continuar = false; // Encerra o loop, voltando ao menu anterior
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
    private void alugarVeiculo() {
        String nomeCliente = buscarCliente();
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);

        String modeloVeiculo = buscarVeiculoLivre();
        Veiculo veiculo = controller.getSistemaDeAluguel().obterVeiculos().realizarBusca(modeloVeiculo);

        boolean verifica = true;
        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String data = "";
        String hora = "";
        LocalDateTime dataEvento;

        System.out.println("Defina uma data para buscar o veículo (formato: DD/MM/AAAA):");
        while (verifica){
            String dataInput = scanner.nextLine();
            if (Validacoes.validarData(dataInput)){
                data = dataInput;
                verifica = false;
            } else {
                System.out.println("Data Inválida! Digite Novamente.");
            }
        }

        System.out.println("Defina um horário para buscar o veículo (formato: HH:MM):");
        while (!verifica){
            String horaInput = scanner.nextLine();
            if (Validacoes.validarHora(horaInput)){
                hora = horaInput;
                verifica = true;
            } else {
                System.out.println("Hora Inválida! Digite Novamente.");
            }
        }

        dataEvento = LocalDateTime.parse(data + " " + hora,formatado);
        Aluguel aluguel = new Aluguel(veiculo, cliente, dataEvento);

        controller.getSistemaDeAluguel().emprestar(aluguel);

        System.out.println("Veículo alugado com sucesso para " + cliente.getNome() + " em " + dataEvento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
    }

    private String buscarCliente() {
        Util.listar("Clientes Cadastados", controller.getSistemaDeAluguel().obterClientes().obterLista());
        System.out.println("\nDigite o nome de um cliente:");
        String nomeCliente = scanner.nextLine();
        return nomeCliente;
    }
    private String buscarVeiculoLivre() {
        Util.listar("Veiculos Disponíveis", controller.getSistemaDeAluguel().obterVeiculos().obterLista());
        System.out.println("\nDigite o modelo de um veículo:");
        String modeloVeiculo = scanner.nextLine();
        return modeloVeiculo;
    }
    private String buscarVeiculoOcupado() {
        String nomeCliente = buscarCliente();
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);
        // Supondo que obterContratosCliente seja um método que retorna todos os contratos para um dado cliente.
        Set<Aluguel> contratosPorCliente = controller.getSistemaDeAluguel().obterContratosCliente(cliente);

        if (!contratosPorCliente.isEmpty()) {
            System.out.println("Veículos Alugados pelo cliente " + nomeCliente + ":");
            for (Aluguel aluguel : contratosPorCliente) {
                System.out.println(aluguel.veiculo().getModelo() + " - " + aluguel.veiculo().getPlaca());
            }
        } else {
            System.out.println("Nenhum veículo alugado encontrado para o cliente: " + nomeCliente);
            return null; // Retornar null se nenhum veículo for encontrado.
        }

        System.out.println("\nDigite a placa de um veículo para devolver:");
        String placaVeiculo = scanner.nextLine();
        return placaVeiculo; // Retorna a placa para usar na devolução.
    }

    private void devolverVeiculo() {
        String nomeCliente = buscarCliente();
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);

        String modeloVeiculo = buscarVeiculoOcupado();
        Veiculo veiculo = controller.getSistemaDeAluguel().obterVeiculos().realizarBusca(modeloVeiculo);

    }

    private void verInformacoes() {
        System.out.println("Lista de Clientes:");
        for(Cliente cliente: controller.getSistemaDeAluguel().obterClientes().obterLista()){
            System.out.println(cliente.obterNomeOrganizado());
        }
        System.out.println("\nLista de Veículos:");
        for(Veiculo veiculo: controller.getSistemaDeAluguel().obterTipo().obterLista()){
            System.out.println(veiculo.obterNomeOrganizado());
        }
    }
}
