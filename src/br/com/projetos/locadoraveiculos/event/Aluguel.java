package br.com.projetos.locadoraveiculos.event;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;

import java.time.LocalDateTime;

public record Aluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataEvento) {}
