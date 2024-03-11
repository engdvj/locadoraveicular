package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.service.Cadastrar;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import java.util.List;

public class SistemaClientes implements Cadastrar<Cliente> {
    List<Cliente> clientes;

    public SistemaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        Util.ordenarClientesPorNome(clientes);
        return clientes; }

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
