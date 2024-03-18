package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
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
        if (veiculos.add(veiculo)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editar(Veiculo veiculoAnterior, Veiculo veiculoNovo) {
        veiculoAnterior.setMarca(veiculoNovo.getMarca());
        veiculoAnterior.setModelo(veiculoNovo.getModelo());
        veiculoAnterior.setPlaca(veiculoNovo.getPlaca());
        veiculoAnterior.setTamanhoVeiculo(veiculoNovo.getTamanhoVeiculo());
        return false;
    }

    @Override
    public Veiculo realizarBusca(String nome) {
        if (Validacoes.validaNome(nome)) {
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca().equalsIgnoreCase(nome)) {
                    return veiculo;
                }
            }
        }
        return null;
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