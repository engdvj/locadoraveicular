package br.com.projetos.locadoraveiculos.model.agencia;

import br.com.projetos.locadoraveiculos.event.Aluguel;

import java.time.LocalTime;
import java.util.List;

public class Agencia {
    private String nome;
    private String endereco;
    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;
    private List<Aluguel> contratos;

    public Agencia(String nome, String endereco, LocalTime horarioAbertura, LocalTime horarioFechamento, List<Aluguel> contratos) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.contratos = contratos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalTime getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(LocalTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public LocalTime getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }
}
