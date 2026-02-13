package br.com.senai.centroweg.service.strategies;
import br.com.senai.centroweg.domain.EstrategiaDeFrete;
import br.com.senai.centroweg.domain.Pedido;

public class FreteGratis implements EstrategiaDeFrete{

    @Override
    public double calcularValorFinal(Pedido pedido) {
        return pedido.getValorBruto(); //Respeita o contrato sem quebrar a lógica
    }
}
