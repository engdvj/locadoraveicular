package br.com.projetos.locadoraveiculos.view.menu;

import br.com.projetos.locadoraveiculos.controller.locadora.ControllerLocadora;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.*;
import br.com.projetos.locadoraveiculos.service.Apresentar;
import br.com.projetos.locadoraveiculos.util.Util;

import static br.com.projetos.locadoraveiculos.util.Validacoes.*;
import static br.com.projetos.locadoraveiculos.view.commandLine.App.*;

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
                    verDados();
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
            boolean adicionado = controller.getSistemaDeAluguel().obterClientes().add(new ClientePF(nomeCliente, cpfCliente));
            if (adicionado) {
                System.out.println("Cliente Adicionado com Sucesso!\n");
            } else {
                System.out.println("Erro na criação do cliente! Cliente com este CPF já existe.\n");
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
            boolean adicionado = controller.getSistemaDeAluguel().obterClientes().add(new ClientePJ(nomeCliente, cnpjCliente));
            if (adicionado) {
                System.out.println("Cliente Adicionado com Sucesso!\n");
            } else {
                System.out.println("Erro na criação do cliente! Cliente com este CNPJ já existe.\n");
            }
        }
    }
    public void verDados() {
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
                boolean verifica = true;
                String cpfCliente = null;
                System.out.println("Digite o novo nome do Cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o novo CPF do Cliente: ");
                while (verifica) {
                    cpfCliente = scanner.nextLine();
                    if (validarDocumento(cpfCliente,"cpf")) {
                        verifica = false;
                    }else{
                        System.out.println("CPF Inválido! Tente novamente.");
                    }
                }
                controller.getSistemaDeAluguel().obterClientes().editar(cliente,new ClientePF(nomeCliente, cpfCliente));
                System.out.println("Cliente editado com sucesso!\n");

            }else{
                boolean verifica = true;
                String cnpjCliente = null;
                System.out.println("Digite o novo nome da empresa: ");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o novo CNPJ da empresa: ");
                while (verifica) {
                    cnpjCliente = scanner.nextLine();
                    if (validarDocumento(cnpjCliente,"cnpj")) {
                        verifica = false;
                    }else{
                        System.out.println("CPF Inválido! Tente novamente.");
                    }
                }
                controller.getSistemaDeAluguel().obterClientes().editar(cliente,new ClientePJ(nomeCliente, cnpjCliente));
                System.out.println("Cliente editado com sucesso!\n");

            }
        }else{
                System.out.println("Cliente não encontrado!\n");
            }
    }
    private void excluirCliente() {
        Cliente cliente = obterCliente();
        if(cliente!= null) {
                controller.getSistemaDeAluguel().obterClientes().remover(cliente);
                System.out.println("Cliente excluído com sucesso!\n");
            }else{
                System.out.println("Cliente não encontrado!\n");
            }
    }
    private Cliente obterCliente() {
        Util.listar("Clientes", controller.getSistemaDeAluguel().obterClientes().obterLista());
        System.out.println("\nDigite o nome do cliente ou da empresa:");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        return controller.getSistemaDeAluguel().obterClientes().realizarBusca(nomeCliente);

    }

//    private void listarClientes() {
//        System.out.println("Lista Atual de Clientes:\n");
//        for(Cliente cliente : controller.getSistemaDeAluguel().obterClientes().obterLista()){
//            System.out.println(cliente.obterNomeOrganizado());
//        }
//    }

}
