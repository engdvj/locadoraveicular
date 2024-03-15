package br.com.projetos.locadoraveiculos.util;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

import java.util.*;

public class Util {
    public enum Tamanho {
        PEQUENO,
        MEDIO,
        SUV;
    }
    public static TreeSet<Cliente> ordenarClientesPorNome(HashSet<Cliente> clientes) {
        Comparator<Cliente> comparadorPorNome = Comparator.comparing(Cliente::obterNomeOrganizado);
        TreeSet<Cliente> ordenadoClientes = new TreeSet<>(comparadorPorNome);
        ordenadoClientes.addAll(clientes); // Adicionando os clientes ao TreeSet, que serão ordenados
        return ordenadoClientes;
    }

    public static <T> TreeSet<T> ordenarPorNome(Set<T> objetos, Comparator<T> comparador) {
        TreeSet<T> ordenado = new TreeSet<>(comparador);
        ordenado.addAll(objetos);
        return ordenado;
    }
}
