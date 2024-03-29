package br.com.projetos.locadoraveiculos.model.entidades.agencia;

import br.com.projetos.locadoraveiculos.model.eventos.Aluguel;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;

import java.time.LocalTime;
import java.util.HashSet;

public record Agencia(String nome, String endereco, LocalTime horarioAbertura, LocalTime horarioFechamento, HashSet<Aluguel> contratosAtivos, HashSet<Devolucao> contratosInativos) {
}
