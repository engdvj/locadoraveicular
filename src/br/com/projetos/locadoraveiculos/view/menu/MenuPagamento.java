package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import java.util.ArrayList;
import java.util.Scanner;

import static br.com.projetos.locadoraveiculos.view.commandLine.ConsoleUI.scanner;

public class MenuPagamento implements Apresentar {

    private final ControllerLocadora controller;
    private Devolucao devolucao;
    private final GerenciadorDeMenu gerenciadorDeMenu;

    public MenuPagamento(ControllerLocadora controller, GerenciadorDeMenu gerenciadorDeMenu, Devolucao devolucao) {
        this.controller = controller;
        this.gerenciadorDeMenu = gerenciadorDeMenu;
        this.devolucao = devolucao;
    }


    @Override
    public void escolherOpcao() {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in); // Considerar mover para uma dependência injetada se usada em múltiplos locais

        System.out.println("""
                Escolha uma opção abaixo:
                 (1) - Realizar Pagamento - Cartão de Crédito
                 (2) - Realizar Pagamento - PIX
                """);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                pagamentoCartao();
                break;
            case "2":
                pagamentoPix();
                break;
            default:
                System.out.println("Opção Inválida!");
        }
    }

    private void pagamentoCartao() {
        ArrayList<Double> valores = controller.getSistemaDePagamento().calcularPagamento(devolucao);
        controller.getSistemaDePagamento().imprimirRecido(valores);


    }

    private void pagamentoPix() {
        controller.getSistemaDePagamento().calcularPagamento(devolucao);
    }
}
