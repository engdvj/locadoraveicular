package br.com.projetos.locadoraveiculos.util;

import java.util.Scanner;

public class Validacoes {
    public static boolean validaNome(String nome){
        if (nome != null && !nome.isEmpty()) {
            return true;
        }
        return false;
    }
    public static Boolean validarDocumento(String documento,String tipo){
        if (documento.length() == 11 && tipo == "cpf"){
            return true;
        }
        if (documento.length() == 14 && tipo == "cnpj"){
            return true;
        }else {
            return false;
        }
    }
}
