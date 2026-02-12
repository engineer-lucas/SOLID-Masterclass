package br.com.senai.centroweg.strategies;
import br.com.senai.centroweg.domain.IEstrategiaDesconto;
import br.com.senai.centroweg.domain.Pedido;
public class DescontoAniversario implements IEstrategiaDesconto{

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValorBruto() * 0.80; //20% de desconto
    }
}
