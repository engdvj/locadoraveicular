package br.com.projetos.locadoraveiculos.model.eventos;

import br.com.projetos.locadoraveiculos.model.entidades.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;

import java.time.LocalDateTime;

public record Aluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataEvento) {}
