package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import java.time.LocalTime;

public class AgenciasDataLoader {
    public static Agencia loadSampleAgencia() {
        String nome = "Dois Irmãos";
        String endereco = "Rua Duque de Caxias";
        LocalTime horarioAbertura = LocalTime.of(9, 0);
        LocalTime horarioFechamento = LocalTime.of(18, 0);

        ContratosDataLoader contratosDataLoader = new ContratosDataLoader();
        ContratosDataLoader.ResultadoContratos resultado = contratosDataLoader.processarContratos(endereco);

        Agencia agencia = new Agencia(nome, endereco, horarioAbertura, horarioFechamento, resultado.getContratosAtivos(), resultado.getContratosInativos());

        return agencia;
    }
}