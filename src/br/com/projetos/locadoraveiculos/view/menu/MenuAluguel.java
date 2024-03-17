package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Set;

import static br.com.projetos.locadoraveiculos.view.commandLine.ConsoleUI.scanner;

public class MenuAluguel implements Apresentar {
    private final ControllerLocadora controller;
    private final GerenciadorDeMenu gerenciadorDeMenu;
    public MenuAluguel(ControllerLocadora controller,GerenciadorDeMenu gerenciadorDeMenu) {
        this.controller = controller;
        this.gerenciadorDeMenu = gerenciadorDeMenu;
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
                    Devolucao devolucao = devolverVeiculo();
                    gerenciadorDeMenu.setMenuAtual(new MenuPagamento(controller, gerenciadorDeMenu,devolucao));
                    gerenciadorDeMenu.exibirMenuAtual();
                    break;
                case "3":
                    //verInformacoes();
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
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(buscarCliente());

        String modeloVeiculo = buscarVeiculoLivre();
        Veiculo veiculo = controller.getSistemaDeAluguel().obterVeiculosDisponiveis().realizarBusca(modeloVeiculo);

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

    private Devolucao devolverVeiculo() {
        String nomeCliente = buscarCliente();
        Cliente cliente = controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);
        Aluguel aluguel;
        String placaVeiculo;

        do {
            placaVeiculo = buscarVeiculoOcupado(cliente);
            aluguel = controller.getSistemaDeAluguel().buscarAluguel(cliente, placaVeiculo);

            if (aluguel == null) {
                System.out.println("Placa digitada incorreta. Por favor, tente novamente.");
            }
        } while (aluguel == null);

        boolean verifica = true;
        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String data = "";
        String hora = "";
        LocalDateTime dataEvento;

        System.out.println("Defina uma data para devolução do veículo (formato: DD/MM/AAAA):");
        while (verifica){
            String dataInput = scanner.nextLine();
            if (Validacoes.validarData(dataInput)){
                data = dataInput;
                verifica = false;
            } else {
                System.out.println("Data Inválida! Digite Novamente.");
            }
        }

        System.out.println("Defina um horário para devolução do veículo (formato: HH:MM):");
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
        Devolucao devolucao = new Devolucao (aluguel,dataEvento);
        controller.getSistemaDeAluguel().devolver(devolucao);
        System.out.println(devolucao);
        return devolucao;
    }
    private String buscarCliente() {
        Util.listar("Clientes Cadastados", controller.getSistemaDeAluguel().obterClientes().obterLista());
        System.out.println("\nDigite o nome de um cliente:");
        return scanner.nextLine();
    }
    private String buscarVeiculoLivre() {
        Util.listar("Veiculos Disponíveis", controller.getSistemaDeAluguel().obterVeiculosDisponiveis().obterLista());
        System.out.println("\nDigite o modelo de um veículo:");
        return scanner.nextLine();
    }
    private String buscarVeiculoOcupado(Cliente cliente) {

        Set<Aluguel> contratosPorCliente = controller.getSistemaDeAluguel().obterContratosCliente(cliente);

        if (!contratosPorCliente.isEmpty()) {
            System.out.println("Veículos Alugados pelo cliente " + cliente.getNome() + ":");
            for (Aluguel aluguel : contratosPorCliente) {
                System.out.println(aluguel.veiculo().getModelo() + " - " + aluguel.veiculo().getPlaca());
            }
        } else {
            System.out.println("Nenhum veículo alugado encontrado para o cliente: " + cliente.getNome());
            return null;
        }

        System.out.println("\nDigite a placa de um veículo para devolver:");
        return scanner.nextLine().toUpperCase(); // Retorna a placa para usar na devolução.
    }


//    private void verInformacoes() {
//        boolean continuar = true;
//        while (continuar) {
//            System.out.println("""
//                    Escolha uma opção abaixo:
//                     (1) - Lista de Alugueis
//                     (2) - Veículos Disponíveis
//                     (3) - Informações por cliente
//                     (4) - Voltar ao Menu Anterior
//                    """);
//            String option = scanner.nextLine();
//            switch (option) {
//                case "1":
//                    alugarVeiculo();
//                    break;
//                case "2":
//                    devolverVeiculo();
//                    break;
//                case "3":
//                    verInformacoes();
//                    break;
//                case "4":
//                    continuar = false; // Encerra o loop, voltando ao menu anterior
//                    break;
//                default:
//                    System.out.println("Opção Inválida!");
//            }
//        }
//        System.out.println("Lista de Clientes:");
//        for(Cliente cliente: controller.getSistemaDeAluguel().obterClientes().obterLista()){
//            System.out.println(cliente.obterNomeOrganizado());
//        }
//        System.out.println("\nLista de Veículos:");
//        for(Veiculo veiculo: controller.getSistemaDeAluguel().obterVeiculosDisponiveis().obterLista()){
//            System.out.println(veiculo.obterNomeOrganizado());
//        }
//    }
}
