package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;

import static br.com.projetos.locadoraveiculos.view.commandLine.App.*;

public class MenuAluguel implements Apresentar {
    private final ControllerLocadora controller;
    public MenuAluguel(ControllerLocadora controller) {
        this.controller = controller;
    }
    @Override
    public void escolherOpcao() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    Escolha uma opção abaixo:
                     (1) - Alugar um veículo
                     (2) - Devolver um veículo
                     (3) - Ver informações
                     (4) - Voltar ao Menu Anterior
                    """);
            String option = scanner.next();
            switch (option) {
                case "1":
                    alugarVeiculo();
                    break;
                case "2":
                    devolverVeiculo();
                    break;
                case "3":
                    verInformacoes();
                    break;
                case "4":
                    continuar = false; // Encerra o loop, voltando ao menu anterior
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
    private void alugarVeiculo() {
        Util.listar("Clientes", controller.getSistemaDeAluguel().obterClientes().obterLista());
        Util.listar("Veiculos", controller.getSistemaDeAluguel().obterVeiculos().obterLista());
    }

    private void devolverVeiculo() {
    }

    private void verInformacoes() {
    }
}
