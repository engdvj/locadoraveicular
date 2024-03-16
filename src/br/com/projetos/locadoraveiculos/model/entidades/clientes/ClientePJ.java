package br.com.projetos.locadoraveiculos.model.entidades.clientes;

public class ClientePJ extends Cliente {
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
    public String formatoDocumento(String CNPJ) {
        StringBuilder sb = new StringBuilder(CNPJ);

        sb.insert(2, '.');
        sb.insert(6, '.');
        sb.insert(10, '/');
        sb.insert(15, '-');

        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(nome).append("\n");
        sb.append("CNPJ: ").append(formatoDocumento(CNPJ)).append("\n");
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ClientePJ)) return false;
        ClientePJ outro = (ClientePJ) o;
        if (CNPJ == null) {
            return outro.CNPJ == null;
        } else {
            return CNPJ.equals(outro.CNPJ);
        }
    }
    @Override
    public int hashCode() {
        return CNPJ.hashCode();
    }
}
