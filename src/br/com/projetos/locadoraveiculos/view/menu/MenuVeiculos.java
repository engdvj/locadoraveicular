package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.*;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import static br.com.projetos.locadoraveiculos.view.commandLine.ConsoleUI.scanner;


public class MenuVeiculos implements Apresentar {
    private final ControllerLocadora controller;

    public MenuVeiculos(ControllerLocadora controller, GerenciadorDeMenu gerenciador) {
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

        boolean validacaoMarca = true;
        String marca = null;
        System.out.print("Digite marca do veículo: ");
        do {
            marca = scanner.nextLine();
            if (Validacoes.validaNome(marca)) {
                marca = marca.substring(0, 1).toUpperCase() + marca.substring(1).toLowerCase();
                validacaoMarca = false;
            } else {
                System.out.println("A marca não pode ser vazio!");
            }
        } while (validacaoMarca);

        boolean validacaoModelo = true;
        String modelo = null;
        System.out.print("Digite o modelo do veículo: ");
        do {
            modelo = scanner.nextLine();
            if (Validacoes.validaNome(modelo)) {
                modelo = modelo.substring(0, 1).toUpperCase() + modelo.substring(1).toLowerCase();
                validacaoModelo = false;
            } else {
                System.out.println("Modelo não pode ser vazio!");
            }
        } while (validacaoModelo);

        boolean validacaoplaca = true;
        String placa = null;
        System.out.print("Digite a placa do veículo:");
        do {
            placa = scanner.nextLine().toUpperCase();
            if (Validacoes.validarPlaca(placa)) {
                System.out.println("Placa validada");
                validacaoplaca = false;
            } else {
                System.out.println("Placa invalida, digite no padrão MercoSul");
            }
        } while (validacaoplaca);

        System.out.println("\nQual o tamanho do veículo?");
        Util.Tamanho tamanho = null;

        while (true) {
            System.out.println("""
                    Pequeno
                    Medio
                    SUV
                    """);
            System.out.print("->");

            String tamanhoVeiculo = scanner.nextLine().toUpperCase();
            if (tamanhoVeiculo.equals("PEQUENO") || tamanhoVeiculo.equals("MEDIO") || tamanhoVeiculo.equals("SUV")) {
                tamanho = Util.Tamanho.valueOf(tamanhoVeiculo);
                break;
            } else {
                System.out.println("Digite um tamanho válido");
            }
        }
            boolean adicionado = controller.getSistemaDeAluguel().obterVeiculos().add(new Veiculo(marca, modelo, placa, tamanho));
        if (adicionado){
            System.out.println("Veiculo adicionado com sucesso!");
        }else{
            System.out.println("Veiculo não pode ser adicionado, placa já existe!");
        }
    }


    public void editarVeiculo() {
        System.out.println("Editar veiculo");
        Veiculo editarVeiculo = obterVeiculo();
        if (editarVeiculo != null) {

            boolean validacaoMarca = true;
            String novaMarca = null;
            System.out.print("qual a nova marca do veículo: ");
            do {
                novaMarca = scanner.nextLine();
                if (Validacoes.validaNome(novaMarca)) {
                    novaMarca = novaMarca.substring(0, 1).toUpperCase() + novaMarca.substring(1).toLowerCase();
                    validacaoMarca = false;
                } else {
                    System.out.println("A marca não pode estar vazia!");
                }
            } while (validacaoMarca);

            boolean validacaoModelo = true;
            String novoModelo = null;
            System.out.print("Digite o modelo do veículo: ");
            do {
                novoModelo = scanner.nextLine();
                if (Validacoes.validaNome(novoModelo)) {
                    novoModelo = novoModelo.substring(0, 1).toUpperCase() + novoModelo.substring(1).toLowerCase();
                    validacaoModelo = false;
                } else {
                    System.out.println("Modelo não pode ser vazio!");
                }
            } while (validacaoModelo);

            boolean validacaoplaca = true;
            String novaPlaca = null;
            System.out.print("Digite a placa do veículo:");
            do {
                novaPlaca = scanner.nextLine().toUpperCase();
                if (Validacoes.validarPlaca(novaPlaca)) {
                    System.out.println("Placa validada");
                    validacaoplaca = false;
                } else {
                    System.out.println("Placa invalida, digite no padrão MercoSul");
                }
            } while (validacaoplaca);

            System.out.println("\nQual o tamanho do veículo?");
            Util.Tamanho tamanho = null;

            while (true) {
                System.out.println("""
                        Pequeno
                        Medio
                        SUV
                        """);
                System.out.print("->");

                String tamanhoVeiculo = scanner.nextLine().toUpperCase();
                if (tamanhoVeiculo.equals("PEQUENO") || tamanhoVeiculo.equals("MEDIO") || tamanhoVeiculo.equals("SUV")) {
                    tamanho = Util.Tamanho.valueOf(tamanhoVeiculo);
                    break;
                } else {
                    System.out.println("Digite um tamanho válido");
                }
            }

            if (controller.getSistemaDeAluguel().obterVeiculos().editar(editarVeiculo, new Veiculo(novaMarca, novoModelo, novaPlaca, tamanho))){
                System.out.println("Veiculo editado com sucesso");
            }else{
                System.out.println("Não foi possivel adicionar veiculo");
            }

        } else {
            System.out.println("Veiculo não encontrado");
        }

    }

    public void excluirVeiculo() {
        Veiculo apagarVeiculo = obterVeiculo();
        if (apagarVeiculo != null) {
            controller.getSistemaDeAluguel().obterVeiculos().remover(apagarVeiculo);
        } else {
            System.out.println("Não foi possivel encontar o veiculo");
        }
    }

    public void veiculoDetalhado() {
        Veiculo veiculo = obterVeiculo();
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veiculo não encontrado");
        }
    }

    public Veiculo obterVeiculo() {
        Util.listar("Veiculos", controller.getSistemaDeAluguel().obterVeiculos().obterLista());
        System.out.println("\nDigite o nome do Veiculo:");
        String pesquisaVeiculo = scanner.nextLine();
        if (!pesquisaVeiculo.isEmpty()) {
            return controller.getSistemaDeAluguel().obterVeiculos().realizarBusca(pesquisaVeiculo);
        } else {
            return null;
        }
    }

}
