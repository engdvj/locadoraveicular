package br.com.projetos.locadoraveiculos.view.commandLine;

import br.com.projetos.locadoraveiculos.controller.locadora.*;
import br.com.projetos.locadoraveiculos.view.menu.GerenciadorDeMenu;

public class App {
        public static void main(String[] args) {
            ControllerLocadora controllerLocadora = InicializarAplicacao.inicializar();
            GerenciadorDeMenu gerenciadorDeMenu = new GerenciadorDeMenu(controllerLocadora);
            ConsoleUI ui = new ConsoleUI(controllerLocadora, gerenciadorDeMenu); // Supondo que ConsoleUI aceite gerenciadorDeMenu agora
            ui.run();
        }
    }
