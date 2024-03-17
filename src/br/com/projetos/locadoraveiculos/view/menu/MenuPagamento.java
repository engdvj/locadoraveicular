package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import java.util.Scanner;

import static br.com.projetos.locadoraveiculos.view.commandLine.ConsoleUI.scanner;

public class MenuPagamento implements Apresentar {

    private final ControllerLocadora controller;

    private final GerenciadorDeMenu gerenciadorDeMenu;

    public MenuPagamento(ControllerLocadora controller, GerenciadorDeMenu gerenciadorDeMenu) {
        this.controller = controller;
        this.gerenciadorDeMenu = gerenciadorDeMenu;
    }


    @Override
    public void escolherOpcao() {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in); // Considerar mover para uma dependência injetada se usada em múltiplos locais

        while (!sair) {
            System.out.println("""
                    Escolha uma opção abaixo:
                     (1) - Realizar Pagamento - Cartão de Crédito
                     (2) - Realizar Pagamento - PIX
                    """);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    gerenciadorDeMenu.setMenuAtual(new MenuClientes(controller, gerenciadorDeMenu));
                    break;
                case "2":
                    gerenciadorDeMenu.setMenuAtual(new MenuVeiculos(controller, gerenciadorDeMenu));
                    break;
                case "3":
                    gerenciadorDeMenu.setMenuAtual(new MenuAluguel(controller, gerenciadorDeMenu));
                    break;
                case "4":
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
            if (!sair) {
                gerenciadorDeMenu.exibirMenuAtual();
            }
        }
    }
}
