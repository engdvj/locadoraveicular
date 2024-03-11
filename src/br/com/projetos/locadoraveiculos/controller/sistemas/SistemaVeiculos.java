package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.service.Cadastrar;
import br.com.projetos.locadoraveiculos.util.Validacoes;

import java.util.List;

public class SistemaVeiculos implements Cadastrar<Veiculo> {
    private List<Veiculo> veiculos;

    public SistemaVeiculos(List<Veiculo> veiculos) {
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
}
