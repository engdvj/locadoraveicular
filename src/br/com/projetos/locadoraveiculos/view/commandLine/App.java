package br.com.projetos.locadoraveiculos.view.commandLine;

import br.com.projetos.locadoraveiculos.controller.locadora.*;
import br.com.projetos.locadoraveiculos.controller.sistemas.*;
import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.*;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.*;
import br.com.projetos.locadoraveiculos.service.*;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.view.menu.MenuInicial;

import java.time.*;

import java.util.*;


public class App {
    public static Apresentar menu;
    public static final Scanner scanner = new Scanner(System.in);


    public App(ControllerLocadora controllerLocadora) {
        menu = new MenuInicial(controllerLocadora);
    }

    public void run() {
        menu.escolherOpcao();
    }

    public static HashSet<Veiculo> loadSampleVeiculos() {
        HashSet<Veiculo> veiculos = new HashSet<>();
        veiculos.add(new Veiculo("Ford", "Focus", "ABC1D23", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Volkswagen", "Jetta", "XYZ9A87", Util.Tamanho.SUV));
        veiculos.add(new Veiculo("Chevrolet", "Cruze", "DEF2B45", Util.Tamanho.PEQUENO));
        veiculos.add(new Veiculo("Fiat", "Toro", "QWE6C78", Util.Tamanho.PEQUENO));
        veiculos.add(new Veiculo("Honda", "Civic", "FHT7F89", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Toyota", "Corolla", "DWX8H23", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Renault", "Duster", "DWX8H27", Util.Tamanho.SUV));
        return veiculos;
    }

    public static HashSet<Cliente> loadSampleClientes() {
        HashSet<Cliente> clientes = new HashSet<>();
        clientes.add(new ClientePF("Caio Brito", "12345678910"));
        clientes.add(new ClientePF("Ingrid Gomes", "32165498711"));
        clientes.add(new ClientePJ("COCA COLA", "45997418001710"));
        clientes.add(new ClientePJ("PEPSICO DO BRASIL", "31565104002030"));
        return clientes;
    }
    public static HashSet<Aluguel> loadSampleContratos() {
        HashSet<Veiculo> veiculos = loadSampleVeiculos();
        HashSet<Cliente> clientes = loadSampleClientes();

        HashSet<Aluguel> contratos = new HashSet<>();
        Iterator<Veiculo> veiculoIterator = veiculos.iterator();
        Iterator<Cliente> clienteIterator = clientes.iterator();

        int index = 0;
        while (veiculoIterator.hasNext() && clienteIterator.hasNext() && index < veiculos.size() && index < clientes.size()) {
            LocalDateTime dataEvento = LocalDateTime.of(2024, Month.MARCH, 10 + index, 10 + (index % 4), 0);
            contratos.add(new Aluguel(veiculoIterator.next(), clienteIterator.next(), dataEvento));
            index++;
        }
        System.out.println(contratos);
        return contratos;
    }
    public static Agencia loadSampleAgencia(){
        Agencia agencia = new Agencia("Dois Irmãos", "Rua Duque de Caxias", LocalTime.of(9, 0), LocalTime.of(18, 0),loadSampleContratos());
        return agencia;
    }

    public static void main(String[] args) {
        Agencia agencia = loadSampleAgencia();
        CRUD<Cliente> sistemaClientes = new SistemaClientes(loadSampleClientes());
        CRUD<Veiculo> sistemaVeiculos = new SistemaVeiculos(loadSampleVeiculos());

        Alugar sistemaDeAluguel = new SistemaAluguel(agencia, sistemaVeiculos, sistemaClientes);

        ControllerLocadora controllerLocadora = new ControllerLocadora(sistemaDeAluguel);

        App cliApp = new App(controllerLocadora);

        cliApp.run();
    }
}