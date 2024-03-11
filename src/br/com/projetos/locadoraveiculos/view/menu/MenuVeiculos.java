package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

public class MenuVeiculos implements Apresentar {
    private final ControllerLocadora controller;
    public MenuVeiculos(ControllerLocadora controller) {
        this.controller = controller;
    }
    @Override
    public void escolherOpcao() {
        System.out.println("Deu certo - Comprei meu carro!");
    }
}
