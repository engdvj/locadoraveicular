package br.com.projetos.locadoraveiculos.model.clientes;

public class ClientePJ extends Cliente{
    private String CNPJ;

    public ClientePJ(String nome, String CNPJ) {
        this.nome = nome;
        this.CNPJ = CNPJ;
    }

    @Override
    public String getDocumento() {
        return this.CNPJ;
    }

    @Override
    public void setDocumento(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String obterNomeOrganizado() {
        StringBuilder sb = new StringBuilder();
        sb.append("PJ - ").append(nome);
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(nome).append("\n");
        sb.append("CNPJ: ").append(CNPJ).append("\n");
        return sb.toString();
    }
}
