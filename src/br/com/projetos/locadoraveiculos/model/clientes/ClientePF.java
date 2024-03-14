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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        ClientePF clientePF = (ClientePF) o;
        return CPF.equals(clientePF.CPF);
    }
    @Override
    public int hashCode() {
        return CPF.hashCode();
    }

}
