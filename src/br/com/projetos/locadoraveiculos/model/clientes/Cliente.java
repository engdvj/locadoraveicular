package br.com.projetos.locadoraveiculos.model.clientes;

public abstract class Cliente {
    protected String nome;
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public abstract String obterNomeOrganizado();
    public abstract String getDocumento();
    public abstract void setDocumento(String document);

}
