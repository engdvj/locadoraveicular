package br.com.projetos.locadoraveiculos.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean validarPlaca(String placa) {
        String regex = "^[A-Za-z]{3}[0-9][A-Za-z][0-9]{2}$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(placa);

        return matcher.matches();
    }
}
