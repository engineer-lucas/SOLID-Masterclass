package br.com.senai.centroweg.services;
import br.com.senai.centroweg.domain.IEstrategiaDesconto;
import br.com.senai.centroweg.domain.Pedido;
public class CalculadoraDesconto {
    //A mágica: ela recebe a interface, não a classe concreta
    public double aplicar(Pedido pedido, IEstrategiaDesconto estrategiaDesconto) {
        return estrategiaDesconto.calcular(pedido);
    }
}
