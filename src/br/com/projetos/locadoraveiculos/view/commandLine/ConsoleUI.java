package br.com.projetos.locadoraveiculos.view.commandLine;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.view.menu.GerenciadorDeMenu;
import br.com.projetos.locadoraveiculos.view.menu.MenuInicial;

import java.util.Scanner;

public class ConsoleUI {
    private final GerenciadorDeMenu gerenciadorDeMenu;

    public static Scanner scanner = new Scanner(System.in);

    public ConsoleUI(ControllerLocadora controllerLocadora, GerenciadorDeMenu gerenciadorDeMenu) {
        // Ajuste conforme necessário para inicializar o MenuInicial com o gerenciadorDeMenu
        this.gerenciadorDeMenu = new GerenciadorDeMenu(controllerLocadora); // ou apenas use o gerenciadorDeMenu passado
        this.gerenciadorDeMenu.setMenuAtual(new MenuInicial(controllerLocadora, this.gerenciadorDeMenu));
    }

    public void run() {
        gerenciadorDeMenu.exibirMenuAtual();
    }
}
