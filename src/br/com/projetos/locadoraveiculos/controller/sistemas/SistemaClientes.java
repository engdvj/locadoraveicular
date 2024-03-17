package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.service.CRUD;
import br.com.projetos.locadoraveiculos.util.*;


import java.util.*;

public class SistemaClientes implements CRUD<Cliente> {
    HashSet<Cliente> clientes;
    public SistemaClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }
    @Override
    public TreeSet<Cliente> obterLista() {
        return Util.ordenar(clientes,Comparator.comparing(Cliente::obterNomeOrganizado)); }

    @Override
    public boolean add(Cliente cliente) {
        return clientes.add(cliente);
    }

    @Override
    public boolean editar(Cliente clienteAnterior, Cliente clienteNovo) {
        if(add(clienteNovo)){
            remover(clienteAnterior);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Cliente realizarBusca(String nome) {
        if (Validacoes.validaNome(nome)) {
            String nomeLowerCase = nome.toLowerCase();
            for (Cliente cliente : clientes) {
                if (cliente.obterNomeOrganizado().toLowerCase().contains(nomeLowerCase)) {
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