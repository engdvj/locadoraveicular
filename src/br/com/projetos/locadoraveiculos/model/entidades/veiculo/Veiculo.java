package br.com.projetos.locadoraveiculos.model.entidades.veiculo;

import br.com.projetos.locadoraveiculos.service.Listar;
import br.com.projetos.locadoraveiculos.util.Util.Tamanho;

public class Veiculo implements Listar {
    private String marca;
    private String modelo;
    private String placa;
    private Tamanho tamanhoVeiculo;

    public Veiculo(String marca, String modelo, String placa, Tamanho tamanhoVeiculo) {
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

    public Tamanho getTamanhoVeiculo() {
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

    public void setTamanhoVeiculo(Tamanho tamanhoVeiculo) {
        this.tamanhoVeiculo = tamanhoVeiculo;
    }

    public String obterNomeOrganizado(){
        StringBuilder sb = new StringBuilder();
        sb.append(tamanhoVeiculo).append(" - ").append(modelo);
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
               "Modelo: " + modelo + "\n" +
               "Placa: " + placa + "\n" +
               "Tamanho: " + tamanhoVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return placa.equals(veiculo.placa);
    }

    @Override
    public int hashCode() {
        return placa.hashCode();
    }
}
