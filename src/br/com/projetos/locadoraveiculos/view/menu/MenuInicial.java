package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import java.util.Scanner;

public class MenuInicial implements Apresentar {
    private final ControllerLocadora controller;
    private final GerenciadorDeMenu gerenciadorDeMenu;

    public MenuInicial(ControllerLocadora controllerLocadora, GerenciadorDeMenu gerenciadorDeMenu) {
        this.controller = controllerLocadora;
        this.gerenciadorDeMenu = gerenciadorDeMenu;
    }

    @Override
    public void escolherOpcao() {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in); // Considerar mover para uma dependência injetada se usada em múltiplos locais

        while (!sair) {
            System.out.println("\nSeja Bem Vindo a " + controller.getSistemaDeAluguel().getAgencia().nome() + "\n");
            System.out.println("""
                    Escolha uma opção abaixo:
                     (1) - Clientes
                     (2) - Veículos
                     (3) - Aluguéis
                     (4) - Sair
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
