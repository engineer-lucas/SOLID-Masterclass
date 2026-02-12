package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
public class CalculadoraFinanceira {
    public double calcularTotal(Pedido pedido){
        double frete = (pedido.getValorTotal() < 500.00) ? 50.00 : 0.0;
        double impostos = pedido.getValorTotal() * 0.15;
        return pedido.getValorTotal() + frete + impostos;
    }
}
