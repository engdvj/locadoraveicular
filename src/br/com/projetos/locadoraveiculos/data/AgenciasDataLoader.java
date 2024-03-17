package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;

import java.time.LocalTime;

import static br.com.projetos.locadoraveiculos.data.ContratosDataLoader.loadSampleContratos;

public class AgenciasDataLoader {
    public static Agencia loadSampleAgencia(){
        Agencia agencia = new Agencia("Dois Irmãos", "Rua Duque de Caxias", LocalTime.of(9, 0), LocalTime.of(18, 0),loadSampleContratos() );
        return agencia;
    }
}
