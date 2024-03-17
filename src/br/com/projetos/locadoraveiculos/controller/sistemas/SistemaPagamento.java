package br.com.projetos.locadoraveiculos.controller.sistemas;

import br.com.projetos.locadoraveiculos.model.entidades.agencia.Agencia;
import br.com.projetos.locadoraveiculos.model.entidades.clientes.ClientePF;
import br.com.projetos.locadoraveiculos.model.eventos.Devolucao;
import br.com.projetos.locadoraveiculos.model.eventos.Pagamento;
import br.com.projetos.locadoraveiculos.service.Pagar;

import java.time.temporal.ChronoUnit;

public class SistemaPagamento implements Pagar {

    private Agencia agencia;


    public SistemaPagamento(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public double calcularPagamento(Devolucao devolucao){
        long diffMinutos = ChronoUnit.MINUTES.between(devolucao.aluguel().dataRetirada(), devolucao.dataDevolucao());
        long numeroDiarias;
        double valorDiarias;
        if (diffMinutos % 1440 == 0){
            numeroDiarias = diffMinutos/1440;
        } else {
            numeroDiarias = (diffMinutos/1440) + 1;
        }
        if (devolucao.aluguel().cliente() instanceof ClientePF){
            if ( numeroDiarias > 5 ) {
                valorDiarias = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias)*0.95;
            } else {
                valorDiarias = devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias;
            }
        } else {
            if (numeroDiarias > 3){
                valorDiarias = (devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias)*0.9;
            } else {
                valorDiarias = devolucao.aluguel().veiculo().getTamanhoVeiculo().getValor() * numeroDiarias;
            }

        }
        return valorDiarias;
    }

    @Override
    public void imprimirRecido(Pagamento pagamento) {

    }


}
