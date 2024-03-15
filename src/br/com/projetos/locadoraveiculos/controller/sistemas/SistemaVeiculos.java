package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.clientes.Cliente;
import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.CRUD;
import br.com.projetos.locadoraveiculos.util.Util;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;


public class SistemaVeiculos implements CRUD<Veiculo> {
    private HashSet<Veiculo> veiculos;

    public SistemaVeiculos(HashSet<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public boolean add(Veiculo veiculo) {
        veiculos.add(veiculo);
        return true;
    }

    @Override
    public Veiculo editar(Veiculo veiculoAnterior, Veiculo veiculoNovo) {
        return null;
    }

    @Override
    public Veiculo realizarBusca(String nome) {
        if(Validacoes.validaNome(nome)) {
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getModelo().contains(nome)) {
                    return veiculo;
                }
            }
        }
        throw new IllegalStateException ("Veículo não encontrado!");
    }
    @Override
    public boolean remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
        return false;
    }
    @Override
    public TreeSet<Veiculo> obterLista() {
        return Util.ordenar(veiculos, Comparator.comparing(Veiculo::getTamanhoVeiculo).thenComparing(Veiculo::obterNomeOrganizado));
    }
}
