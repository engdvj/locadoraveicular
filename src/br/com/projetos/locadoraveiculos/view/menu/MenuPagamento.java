package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.controller.sistemas.SistemaPagamento;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.ClientePF;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import java.time.temporal.ChronoUnit;
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

        while (!sair) {
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
            if (!sair) {
                gerenciadorDeMenu.exibirMenuAtual();
            }
        }
    }

    private void pagamentoCartao(){

    }
    private void pagamentoPix(){
        long diffMinutos = ChronoUnit.MINUTES.between(devolucao.aluguel().dataRetirada(), devolucao.dataDevolucao());
        long numeroDiarias;
        if (diffMinutos % 1440 == 0){
            numeroDiarias = diffMinutos/1440;
        } else {
            numeroDiarias = (diffMinutos/1440)+1;
        }
    }
}
