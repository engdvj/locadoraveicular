package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.ClientePF;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.ClientePJ;

import java.util.HashSet;

public class ClientesDataLoader {
    public static HashSet<Cliente> loadSampleClientes() {
        HashSet<Cliente> clientes = new HashSet<>();
        clientes.add(new ClientePF("Caio Brito", "12345678910"));
        clientes.add(new ClientePF("Ingrid Gomes", "32165498711"));
        clientes.add(new ClientePJ("COCA COLA", "45997418001710"));
        clientes.add(new ClientePJ("PEPSICO DO BRASIL", "31565104002030"));
        return clientes;
    }
}
