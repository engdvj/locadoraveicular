package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.service.Apresentar;

public class GerenciadorDeMenu {
    private Apresentar menuAtual;

    public GerenciadorDeMenu(ControllerLocadora controllerLocadora) {
        this.menuAtual = new MenuInicial(controllerLocadora, this);
    }

    public void setMenuAtual(Apresentar novoMenu) {
        this.menuAtual = novoMenu;
    }

    public void exibirMenuAtual() {
        if (menuAtual != null) {
            menuAtual.escolherOpcao();
        }
    }
}