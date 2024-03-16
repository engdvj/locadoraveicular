package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.*;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import static br.com.projetos.locadoraveiculos.view.commandLine.App.scanner;

public class MenuVeiculos implements Apresentar {
    private final ControllerLocadora controller;

    public MenuVeiculos(ControllerLocadora controller) {
        this.controller = controller;
    }

    @Override
    public void escolherOpcao() {
        boolean continuar = true;
        while (continuar) {

            System.out.println("\nMenu Veiculo\n");

            System.out.println("""
                    (1) - Adicionar veiculo
                    (2) - Editar veiculo
                    (3) - Apagar veiculo
                    (4) - Pesquisar veiculo
                    (5) - Voltar para o menu anterior
                    """);

            System.out.print("->");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    adicionarVeiculo();
                    break;
                case "2":
                    editarVeiculo();
                    break;
                case "3":
                    excluirVeiculo();
                    break;
                case "4":
                    veiculoDetalhado();
                    break;
                case "5":
                    continuar = false;
                    break;
                default:
                    System.out.println("digite uma opção valida");
            }
        }
    }

    public void adicionarVeiculo() {
        System.out.print("Digite marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        boolean validado = false;
        String placa = "";
        while (!validado) {
            System.out.print("Digite a placa do veículo");
            placa = scanner.nextLine().toUpperCase();
            if (Validacoes.validarPlaca(placa)) {
                validado = true;
            }
            System.out.println("Placa invalida, digite no padrão MercoSul");
        }
        System.out.println("\nQual o tamanho do veículo?");
        System.out.println("""
                Pequeno
                Medio
                SUV
                """);
        System.out.print("->");
        String tamanhoVeiculo = scanner.nextLine().toUpperCase();

        Util.Tamanho tamanho = Util.Tamanho.valueOf(tamanhoVeiculo);
        System.out.println(tamanho);
        controller.getSistemaDeAluguel().obterTipo().add(new Veiculo(marca, modelo, placa, tamanho));
    }

    public void editarVeiculo() {
        System.out.println("Editar veiculo");
        Veiculo editarVeiculo = obterVeiculo();
        if (editarVeiculo != null) {
            System.out.print("Digite a nova marca: ");
            String marca = scanner.nextLine();

            System.out.print("Digite o novo modelo: ");
            String modelo = scanner.nextLine();

            String placa = "";
            boolean validacao = false;

            while (!validacao) {
                System.out.print("Digite a nova placa: ");
                placa = scanner.nextLine().toUpperCase();
                if (Validacoes.validarPlaca(placa)) {
                    validacao = true;
                } else {
                    System.out.println("Placa invalida, digite no padrão MercoSul");
                }
            }
            System.out.println("\nDigite o novo tamanho");
            System.out.print("""
                    Pequeno
                    Medio
                    Suv
                    """);
            String tamanhoEnum = scanner.nextLine().toUpperCase();
            Util.Tamanho tamanho = Util.Tamanho.valueOf(tamanhoEnum);

            controller.getSistemaDeAluguel().obterTipo().editar(editarVeiculo, new Veiculo(marca, modelo, placa, tamanho));

        } else {
            System.out.println("Veiculo não encontrado");
        }

    }

    public void excluirVeiculo() {
        Veiculo apagarVeiculo = obterVeiculo();
        if (apagarVeiculo != null) {
            controller.getSistemaDeAluguel().obterTipo().remover(apagarVeiculo);
        } else {
            System.out.println("Não foi possivel encontar o veiculo");
        }
    }

    public void veiculoDetalhado() {
        listarVeiculo();
        Veiculo veiculo = obterVeiculo();
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veiculo não encontrado");
        }
    }

    public void listarVeiculo() {
        System.out.println("\nLista de veiculos\n");
        for (Veiculo veiculo : controller.getSistemaDeAluguel().obterTipo().obterLista()) {
            System.out.println(veiculo.obterNomeOrganizado());
        }
    }

    public Veiculo obterVeiculo() {
        listarVeiculo();
        String pesquisaVeiculo = scanner.nextLine();
        if (!pesquisaVeiculo.isEmpty()) {
            return controller.getSistemaDeAluguel().obterTipo().realizarBusca(pesquisaVeiculo);
        } else {
            return null;
        }
    }
}
