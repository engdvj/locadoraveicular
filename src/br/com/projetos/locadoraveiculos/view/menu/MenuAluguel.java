package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

public class MenuAluguel implements Apresentar {
    private final ControllerLocadora controller;
    public MenuAluguel(ControllerLocadora controller) {
        this.controller = controller;
    }
    @Override
    public void escolherOpcao() {
        System.out.println("Deu certo - Aluguei meu AP!");

    }
}
