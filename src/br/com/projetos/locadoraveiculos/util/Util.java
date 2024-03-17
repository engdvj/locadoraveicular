package br.com.projetos.locadoraveiculos.util;

import br.com.projetos.locadoraveiculos.service.Listar;


import java.util.*;

public class Util {
    public enum Tamanho {
        PEQUENO(100),
        MEDIO(150),
        SUV(200);

        private final double valor;

        Tamanho(double valor){
            this.valor = valor;
        }
        public double getValor(){
            return valor;
        }
    }
    public static <T> TreeSet<T> ordenar(Set<T> objetos, Comparator<T> comparador) {
        TreeSet<T> ordenado = new TreeSet<>(comparador);
        ordenado.addAll(objetos);
        return ordenado;
    }

    public static <T> void listar(String mensagem, Set<? extends Listar> conjunto) {
        System.out.println("Lista de " + mensagem + ":");
        for (Listar elemento : conjunto) {
            System.out.println(elemento.obterNomeOrganizado());
        }
    }
}
