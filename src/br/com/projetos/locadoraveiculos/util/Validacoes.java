package br.com.projetos.locadoraveiculos.util;

public class Validacoes {
    public static boolean validaNome(String nome){
        if (nome != null && !nome.isEmpty()) {
            return true;
        }
        return false;
    }
}
