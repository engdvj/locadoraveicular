package br.com.projetos.locadoraveiculos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validacoes {
    public static boolean validaNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarDocumento(String documento, String tipo) {
        if (documento.length() == 11 && tipo == "cpf") {
            return true;
        }
        if (documento.length() == 14 && tipo == "cnpj") {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarData(String data) {
        try {
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime.parse(data + " 00:00", formatado);
            System.out.println("Data Validada");
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validarHora(String hora) {
        try {
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime.parse("01/01/2024 " + hora, formatado);
            System.out.println("Hora validada.");
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


}
