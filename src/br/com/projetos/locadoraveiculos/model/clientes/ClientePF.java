package br.com.projetos.locadoraveiculos.model.clientes;

public class ClientePF extends Cliente{
    private String CPF;

    public ClientePF(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    @Override
    public String obterNomeOrganizado() {
        StringBuilder sb = new StringBuilder();
        sb.append("PF - ").append(nome);
        return sb.toString();
    }

    @Override
    public String getDocumento() {
        return this.CPF;
    }

    @Override
    public void setDocumento(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(nome).append("\n");
        sb.append("CPF: ").append(CPF).append("\n");
        return sb.toString();
    }
}
