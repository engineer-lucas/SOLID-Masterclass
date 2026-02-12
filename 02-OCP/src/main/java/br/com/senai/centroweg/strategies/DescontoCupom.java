package br.com.senai.centroweg.strategies;
//Aqui é onde o sistema é Aberto para Extensão. Criamos uma classe para cada regra
import br.com.senai.centroweg.domain.IEstrategiaDesconto;
import br.com.senai.centroweg.domain.Pedido;
public class DescontoCupom implements IEstrategiaDesconto{
    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValorBruto() * 0.90; // 10% de desconto
    }
}
