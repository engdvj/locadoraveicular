package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;

import java.time.LocalDateTime;
import java.time.format.*;


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
        Util.listar("Clientes", controller.getSistemaDeAluguel().obterClientes().obterLista());
        System.out.println("\nEscolha um cliente da lista acima:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);

        Util.listar("Veiculos", controller.getSistemaDeAluguel().obterVeiculos().obterLista());
        System.out.println("\nEscolha um veículo da lista acima:");
        String modeloVeiculo = scanner.nextLine();
        Veiculo veiculo = controller.getSistemaDeAluguel().obterVeiculos().realizarBusca(modeloVeiculo);

        System.out.println("Defina uma data para buscar o veículo (formato: DD/MM/AAAA):");
        String dataInput = scanner.nextLine();

        System.out.println("Defina um horário para buscar o veículo (formato: HH:MM):");
        String horaInput = scanner.nextLine();

        LocalDateTime dataEvento;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataEvento = LocalDateTime.parse(dataInput + " " + horaInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data/horário inválido. Cancelando o aluguel.");
            return;
        }

        Aluguel aluguel = new Aluguel(veiculo, cliente, dataEvento);

        controller.getSistemaDeAluguel().emprestar(aluguel);

        System.out.println("Veículo alugado com sucesso para " + cliente.getNome() + " em " + dataEvento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    private void devolverVeiculo() {
    }

    private void verInformacoes() {

    }
}
