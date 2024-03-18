package br.com.projetos.locadoraveiculos.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate hoje = LocalDate.now();
            LocalDate dataValidada = LocalDate.parse(data, formatado);
            if (!dataValidada.isBefore(hoje)) {
                System.out.println("Data válida.");
                return true;
            } else {
                System.out.println("A data fornecida é anterior à data atual.");
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validarHora(String hora) {
        try {
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime agora = LocalDateTime.now();
            String dataHoraFutura = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + hora;
            LocalDateTime dataHoraValidada = LocalDateTime.parse(dataHoraFutura, formatado);
            if (dataHoraValidada.isAfter(agora) || dataHoraValidada.toLocalDate().isEqual(agora.toLocalDate())) {
                System.out.println("Hora válida.");
                return true;
            } else {
                System.out.println("A hora fornecida é anterior à hora atual.");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora inválido.");
            return false;
        }
    }
    public static boolean validarPlaca(String placa) {
        String regex = "^[A-Za-z]{3}[0-9][A-Ja-j][0-9]{2}$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(placa);

        return matcher.matches();
    }
}
