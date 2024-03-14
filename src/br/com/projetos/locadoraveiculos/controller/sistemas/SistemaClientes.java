package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.service.CRUD;
import br.com.projetos.locadoraveiculos.util.*;


import java.util.*;

public class SistemaClientes implements CRUD<Cliente> {
    HashSet<Cliente> clientes;
    public SistemaClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }
    @Override
    public TreeSet<Cliente> obterTipo() {
        TreeSet<Cliente> listaOrdenada = Util.ordenarClientesPorNome(clientes);
        return listaOrdenada; }

    @Override
    public boolean add(Cliente cliente) {
        clientes.add(cliente);
        return true;
    }

    @Override
    public Cliente editar(Cliente clienteAnterior,Cliente clienteNovo) {
        clienteAnterior.setNome(clienteNovo.getNome());
        clienteAnterior.setDocumento(clienteNovo.getDocumento());
        return null;
    }

    @Override
    public Cliente realizarBusca(String nome) {
        if (Validacoes.validaNome(nome)) {
            for (Cliente cliente : clientes) {
                if (cliente.obterNomeOrganizado().contains(nome)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remover(Cliente cliente) {
        clientes.remove(cliente);
        return false;
    }
}
