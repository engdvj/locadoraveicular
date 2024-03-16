package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import static br.com.projetos.locadoraveiculos.view.commandLine.App.*;

public class MenuInicial implements Apresentar {
    private final ControllerLocadora controller;
    public MenuInicial(ControllerLocadora controllerLocadora) {
        this.controller = controllerLocadora;
    }
    @Override
    public void escolherOpcao() {
        boolean sair = false;
        while (!sair) {

            System.out.println("\nSeja Bem Vindo a " + controller.getSistemaDeAluguel().getAgencia().nome()+"\n");
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
                    menu = new MenuClientes(controller);
                    menu.escolherOpcao();
                    break;
                case "2":
                    menu = new MenuVeiculos(controller);
                    menu.escolherOpcao();
                    break;
                case "3":
                    menu = new MenuAluguel(controller);
                    menu.escolherOpcao();
                    break;
                case "4":
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
