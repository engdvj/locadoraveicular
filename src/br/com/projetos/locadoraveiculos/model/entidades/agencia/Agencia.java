package br.com.projetos.locadoraveiculos.model.entidades.agencia;

import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;

import java.time.LocalTime;
import java.util.List;

public record Agencia(String nome, String endereco, LocalTime horarioAbertura, LocalTime horarioFechamento, List<Aluguel> contratos) {
}
