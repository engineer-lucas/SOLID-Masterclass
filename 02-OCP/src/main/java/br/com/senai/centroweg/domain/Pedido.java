package br.com.senai.centroweg.domain;
//Aqui definimos o contrato. Se o marketing inventar 50 novos descontos, o contrato permanece o mesmo.
public class Pedido {
    private String id;
    private double valorBruto;

    public Pedido(String id, double valorBruto) {
        this.id = id;
        this.valorBruto = valorBruto;
    }

    public double getValorBruto() {
        return valorBruto;
    }
}
