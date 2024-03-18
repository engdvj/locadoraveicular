package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.ClientePF;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.model.eventos.Pagamento;
import br.com.projetos.locadoraveiculos.service.Pagar;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SistemaPagamento implements Pagar {

    private Agencia agencia;


    public SistemaPagamento(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public ArrayList<Double> calcularPagamento(Devolucao devolucao) {
        ArrayList<Double> informacoesPagamento = new ArrayList<>();
        double valorDiarias;
        long diffMinutos = ChronoUnit.MINUTES.between(devolucao.aluguel().dataRetirada(), devolucao.dataDevolucao());
        double numeroDiarias;
        double valorDescontado = 0;

        numeroDiarias = Math.ceil(diffMinutos / 1440.0);

        informacoesPagamento.add(numeroDiarias);

        if (devolucao.aluguel().cliente() instanceof ClientePF) {
            if (numeroDiarias > 5) {
                valorDiarias = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias) * 0.95;
                valorDescontado = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias) * 0.05;
            } else {
                valorDiarias = devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias;
            }
        } else {
            if (numeroDiarias > 3) {
                valorDiarias = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias) * 0.9;
                valorDescontado = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias) * 0.1;
            } else {
                valorDiarias = devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias;
            }
        }

        informacoesPagamento.add(valorDescontado);
        informacoesPagamento.add(valorDiarias);
        return informacoesPagamento;
    }

    @Override
    public void imprimirRecido(ArrayList<Double> dadosPagamento) {
        System.out.printf("Numero de diarias: %.0f\n Desconto Aplicado: %.2f\n Valor Total: %.2f ",dadosPagamento.get(0),dadosPagamento.get(1),dadosPagamento.get(2));
    }


}
