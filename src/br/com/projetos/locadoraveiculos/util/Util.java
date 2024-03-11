package br.com.projetos.locadoraveiculos.util;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {
    public enum Tamanho {
        PEQUENO,
        MEDIO,
        SUV;
    }
    public static void ordenarClientesPorNome(List<Cliente> clientes) {
        Collections.sort(clientes, Comparator.comparing(Cliente::obterNomeOrganizado));
    }
}
