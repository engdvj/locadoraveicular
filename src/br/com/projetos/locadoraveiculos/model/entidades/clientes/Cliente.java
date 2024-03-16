package br.com.projetos.locadoraveiculos.model.entidades.clientes;

import br.com.projetos.locadoraveiculos.service.Lista;

public abstract class Cliente implements Lista {
    protected String nome;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public abstract String obterNomeOrganizado();
    public abstract String getDocumento();
    public abstract void setDocumento(String document);
    public abstract String formatoDocumento(String documento);

}
