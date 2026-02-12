package br.com.senai.centroweg.strategies;
import br.com.senai.centroweg.domain.IEstrategiaDesconto;
import br.com.senai.centroweg.domain.Pedido;
public class DescontoVip implements IEstrategiaDesconto{
    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValorBruto() * 0.85; //15% de desconto
    }
}
