package br.com.projetos.locadoraveiculos.model.veiculo;

import br.com.projetos.locadoraveiculos.util.Util.Tamanho;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    Enum<Tamanho> tamanhoVeiculo;

    public Veiculo(String marca, String modelo, String placa, Enum<Tamanho> tamanhoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tamanhoVeiculo = tamanhoVeiculo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public Enum<Tamanho> getTamanhoVeiculo() {
        return tamanhoVeiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTamanhoVeiculo(Enum<Tamanho> tamanhoVeiculo) {
        this.tamanhoVeiculo = tamanhoVeiculo;
    }

    public String obterNomeOrganizado() {
        StringBuilder sb = new StringBuilder();
        sb.append(tamanhoVeiculo).append(" - ").append(modelo);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "\nVeiculo:\n" +
               marca + " " +
               modelo + " " +
               "\nPlaca-|" + placa.substring(0, 3) + "-" + placa.substring(3) + "|" + " \n"
               + tamanhoVeiculo;
    }
}
