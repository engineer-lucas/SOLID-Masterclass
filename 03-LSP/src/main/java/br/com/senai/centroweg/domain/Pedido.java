package br.com.senai.centroweg.domain;

public class Pedido {
    private String id;
    private double valorBruto;

    public Pedido(String id, double valorBruto) {
        this.id = id;
        this.valorBruto = valorBruto;
    }

    public String getId() { return id; }
    public double getValorBruto() { return valorBruto; }
}
