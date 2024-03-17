package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;

import java.time.LocalTime;

import static br.com.projetos.locadoraveiculos.data.ContratosDataLoader.*;

public class AgenciasDataLoader {
    public static Agencia loadSampleAgencia(){
        String nome = "Dois Irmãos";
        String endereco = "Rua Duque de Caxias";
        Agencia agencia = new Agencia(nome, endereco, LocalTime.of(9, 0), LocalTime.of(18, 0),loadSampleContratosAtivos(endereco),loadSampleContratosInativos(loadSampleContratosAtivos(endereco)) );
        return agencia;
    }
}
