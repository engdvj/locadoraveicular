package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.clientes.*;
import br.com.projetos.locadoraveiculos.service.Apresentar;

import static br.com.projetos.locadoraveiculos.util.Validacoes.*;
import static br.com.projetos.locadoraveiculos.view.commandLine.App.scanner;

public class MenuClientes implements Apresentar {
    private final ControllerLocadora controller;
    public MenuClientes(ControllerLocadora controller) {
        this.controller = controller;
    }
    @Override
    public void escolherOpcao() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    Escolha uma opção abaixo:
                     (1) - Adicionar um Novo Cliente
                     (2) - Ver Dados de um Cliente
                     (3) - Editar um Cliente
                     (4) - Excluir um Cliente
                     (5) - Voltar ao Menu Anterior
                    """);
            String option = scanner.next();
            switch (option) {
                case "1":
                    novoCliente();
                    break;
                case "2":
                    verDadosCliente();
                    break;
                case "3":
                    editarCliente();
                    break;
                case "4":
                    excluirCliente();
                    break;
                case "5":
                    continuar = false; // Encerra o loop, voltando ao menu anterior
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
    private void novoCliente() {
        System.out.println("""
                Escolha o tipo de cliente:
                (1) - Pessoa Física
                (2) - Pessoa Jurídica
                """);
        int valor = scanner.nextInt();
        scanner.nextLine();
        while (valor < 1 || valor > 2) { // Corrigido para verificar se o valor está fora do intervalo
            System.out.println("Opção Inválida! Tente novamente.");
            valor = scanner.nextInt();
            scanner.nextLine();
        }
        if (valor == 1) {
            System.out.println("Digite o Nome do Cliente: ");
            String nomeCliente = scanner.nextLine();
            boolean verifica = true;
            String cpfCliente = null;

            System.out.println("Digite o CPF: ");
            while (verifica) {
                cpfCliente = scanner.nextLine();
                if (validarDocumento(cpfCliente,"cpf")) {
                    verifica = false;
                }else{
                    System.out.println("CPF Inválido! Tente novamente.");
                }
            }
            if (controller.getSistemaDeClientes().add(new ClientePF(nomeCliente, cpfCliente))) {
                System.out.println("Cliente Adicionado com Sucesso!\n");
            } else {
                System.out.println("Erro na criação do cliente!\n");
            }

        } else {
            System.out.println("Digite o Nome da Empresa: ");
            String nomeCliente = scanner.nextLine();
            boolean verifica = true;
            String cnpjCliente = null;

            System.out.println("Digite o CNPJ: ");
            while (verifica) {
                cnpjCliente = scanner.nextLine();
                if (validarDocumento(cnpjCliente,"cnpj")) {
                    verifica = false;
                }else{
                    System.out.println("CNPJ Inválido! Tente novamente.");
                }
            }
            if (controller.getSistemaDeClientes().add(new ClientePJ(nomeCliente, cnpjCliente))) {
                System.out.println("Cliente Adicionado com Sucesso!\n");
            } else {
                System.out.println("Erro na criação do cliente!\n");
            }
        }
    }
    private void verDadosCliente() {
        Cliente cliente = obterCliente();
        if(cliente != null) {
                System.out.println(cliente);
            }else{
                System.out.println("Cliente não encontrado!\n");
            }
    }
    private void editarCliente() {
        Cliente cliente = obterCliente();
        if(cliente!= null) {
            if(cliente instanceof ClientePF) {
                System.out.println("Digite o novo nome do Cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o novo CPF do Cliente: ");
                String cpfCliente = scanner.nextLine();
                controller.getSistemaDeClientes().editar(cliente,new ClientePF(nomeCliente, cpfCliente));
                System.out.println("Cliente editado com sucesso!\n");

            }else{
                System.out.println("Digite o novo nome da empresa: ");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o novo CNPJ da empresa: ");
                String cpfCliente = scanner.nextLine();
                controller.getSistemaDeClientes().editar(cliente,new ClientePJ(nomeCliente, cpfCliente));
                System.out.println("Cliente editado com sucesso!\n");

            }
        }else{
                System.out.println("Cliente não encontrado!\n");
            }
    }
    private void excluirCliente() {
        Cliente cliente = obterCliente();
        if(cliente!= null) {
                controller.getSistemaDeClientes().remover(cliente);
                System.out.println("Cliente excluído com sucesso!\n");
            }else{
                System.out.println("Cliente não encontrado!\n");
            }
    }
    private Cliente obterCliente() {
        System.out.println("Lista Atual de Clientes:\n");
        for(Cliente cliente : controller.getSistemaDeClientes().obterTipo()){
            System.out.println(cliente.obterNomeOrganizado());
        }
        System.out.println("\nDigite o nome do cliente ou da empresa:");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        Cliente cliente = controller.getSistemaDeClientes().realizarBusca(nomeCliente);
        return cliente;
    }
}
