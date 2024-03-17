package br.com.projetos.locadoraveiculos.data;

import br.com.projetos.locadoraveiculos.model.entidades.veiculo.Veiculo;
import br.com.projetos.locadoraveiculos.util.Util;
import java.util.HashSet;
import java.util.Set;

public class VeiculosDataLoader {
    public static HashSet<Veiculo> loadSampleVeiculos() {
        HashSet<Veiculo> veiculos = new HashSet<>();
        veiculos.add(new Veiculo("Ford", "Focus", "ABC1D23", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Volkswagen", "Jetta", "XYZ9A87", Util.Tamanho.SUV));
        veiculos.add(new Veiculo("Chevrolet", "Cruze", "DEF2B45", Util.Tamanho.PEQUENO));
        veiculos.add(new Veiculo("Fiat", "Toro", "QWE6C78", Util.Tamanho.PEQUENO));
        veiculos.add(new Veiculo("Honda", "Civic", "FHT7F89", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Toyota", "Corolla", "DWX8H23", Util.Tamanho.MEDIO));
        veiculos.add(new Veiculo("Renault", "Duster", "DWX8H27", Util.Tamanho.SUV));

        return veiculos;
    }
}