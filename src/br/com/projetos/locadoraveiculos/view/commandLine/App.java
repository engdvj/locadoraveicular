package br.com.projetos.locadoraveiculos.view.commandLine;

import br.com.projetos.locadoraveiculos.controller.locadora.*;
import br.com.projetos.locadoraveiculos.controller.sistemas.*;
import br.com.projetos.locadoraveiculos.model.clientes.*;
import br.com.projetos.locadoraveiculos.model.veiculo.*;
import br.com.projetos.locadoraveiculos.service.*;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.view.menu.MenuInicial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    private final ControllerLocadora controller;
    private final MenuInicial menuInicial;
    public static final Scanner scanner = new Scanner(System.in);


    public App(ControllerLocadora controllerLocadora) {
        this.controller = controllerLocadora;
        this.menuInicial = new MenuInicial(controllerLocadora);
    }

    public void run(){
        menuInicial.escolherOpcao();
    }
    public static List<Veiculo> loadSampleVeiculos(){
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Veiculo("Ford", "Focus", "123456789", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Volkswagen", "Jetta", "123456789", Util.Tamanho.SUV));
        return veiculos;
    }
    public static List<Cliente> loadSampleClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new ClientePF("Caio Brito", "123.456.789-10"));
        clientes.add(new ClientePF("Ingrid Gomes", "321.654.987-11"));
        clientes.add(new ClientePJ("COCA COLA", "45.997.418/0017-10"));
        clientes.add(new ClientePJ("PEPSICO DO BRASIL", "31.565.104/0020-30"));
        return clientes;
    }

    public static void main(String[] args) {
    Cadastrar<Cliente> sistemaClientes = new SistemaClientes(loadSampleClientes());
    Cadastrar<Veiculo> sistemaVeiculos = new SistemaVeiculos(loadSampleVeiculos());

    Alugar sistemaDeAluguel = new SistemaAluguel(sistemaVeiculos,sistemaClientes);

    ControllerLocadora controllerLocadora = new ControllerLocadora("Locadora Dois Irmãos",sistemaDeAluguel);

    App cliApp = new App(controllerLocadora);

    cliApp.run();
    }
}