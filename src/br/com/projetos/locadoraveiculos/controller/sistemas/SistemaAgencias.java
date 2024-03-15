package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.agencia.AgenciaAluguel;
import br.com.projetos.locadoraveiculos.service.CRUD;
import java.util.HashSet;
import java.util.TreeSet;

public class SistemaAgencias implements CRUD<AgenciaAluguel> {
    HashSet<AgenciaAluguel> agencias;

    public SistemaAgencias(HashSet<AgenciaAluguel> agencias) {
        this.agencias = agencias;
    }

    @Override
    public boolean add(AgenciaAluguel agenciaAluguel) {
        return agencias.add(agenciaAluguel);
    }

    @Override
    public AgenciaAluguel editar(AgenciaAluguel item, AgenciaAluguel newItem) {
        return null;
    }

    @Override
    public AgenciaAluguel realizarBusca(String nome) {
        return null;
    }

    @Override
    public boolean remover(AgenciaAluguel item) {
        return false;
    }

    @Override
    public TreeSet<AgenciaAluguel> obterTipo() {
        return null;
    }
}
