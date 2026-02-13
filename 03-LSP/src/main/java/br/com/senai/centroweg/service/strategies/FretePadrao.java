package br.com.senai.centroweg.service.strategies;
import br.com.senai.centroweg.domain.EstrategiaDeFrete;
import br.com.senai.centroweg.domain.Pedido;

public class FretePadrao implements EstrategiaDeFrete{
    @Override
    public double calcularValorFinal(Pedido pedido) {
        return pedido.getValorBruto() + 50.0; // Pós-condição: valor final > bruto
    }
}
