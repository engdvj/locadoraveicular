package br.com.projetos.locadoraveiculos.model.entidades.clientes;

public class ClientePF extends Cliente {
    private String CPF;

    public ClientePF(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    @Override
    public String getDocumento() {
        return CPF;
    }

    @Override
    public void setDocumento(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String obterNomeOrganizado() {
        StringBuilder sb = new StringBuilder();
        sb.append("PF - ").append(nome);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(nome).append("\n");
        sb.append("CPF: ").append(formatoDocumento(CPF)).append("\n");
        return sb.toString();
    }
    @Override
    public String formatoDocumento(String CPF) {
        StringBuilder sb = new StringBuilder(CPF);

        sb.insert(3, '.');
        sb.insert(7, '.');
        sb.insert(11, '-');

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ClientePF)) return false;
        ClientePF outro = (ClientePF) o;
        if (CPF == null) {
            return outro.CPF == null;
        } else {
            return CPF.equals(outro.CPF);
        }
    }
    @Override
    public int hashCode() {
        return CPF.hashCode();
    }

}
