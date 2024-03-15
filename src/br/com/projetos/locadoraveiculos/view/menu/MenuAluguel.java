package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.controller.sistemas.SistemaAgencias;
import br.com.projetos.locadoraveiculos.model.agencia.AgenciaAluguel;
import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import static br.com.projetos.locadoraveiculos.view.commandLine.App.scanner;

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
                     (1) - Alugar um Veiculo
                     (2) - Devolver um Veiculo
                     (3) - Voltar ao Menu Anterior
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
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    private void alugarVeiculo() {
        System.out.println("Escolha o local para retirada: ");
        obterAgencia();
        int valor = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Alugado com sucesso!");
    }

    private void devolverVeiculo(){

        System.out.println("Devolvido com sucesso!");
    }

    private void obterAgencia() {
        for(AgenciaAluguel agenciaAluguel : controller.getSistemDeAgencias().obterTipo()){
            System.out.println(agenciaAluguel.getNome());

        }
    }
}
