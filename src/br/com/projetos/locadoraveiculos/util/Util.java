package br.com.projetos.locadoraveiculos.util;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;

import java.util.*;

public class Util {
    public enum Tamanho {
        PEQUENO,
        MEDIO,
        SUV;
    }
    public static <T> TreeSet<T> ordenar(Set<T> objetos, Comparator<T> comparador) {
        TreeSet<T> ordenado = new TreeSet<>(comparador);
        ordenado.addAll(objetos);
        return ordenado;
    }
}
