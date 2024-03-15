package br.com.projetos.locadoraveiculos.util;

import br.com.projetos.locadoraveiculos.service.Lista;

import java.util.*;

public class Util {
    public enum Tamanho {
        PEQUENO,
        MEDIO,
        SUV
    }
    public static <T> TreeSet<T> ordenar(Set<T> objetos, Comparator<T> comparador) {
        TreeSet<T> ordenado = new TreeSet<>(comparador);
        ordenado.addAll(objetos);
        return ordenado;
    }

    public static <T> void listar(String mensagem, Set<? extends Lista> conjunto) {
        System.out.println("Lista de " + mensagem + ":");
        for (Lista elemento : conjunto) {
            System.out.println(elemento.obterNomeOrganizado());
        }
    }
}
