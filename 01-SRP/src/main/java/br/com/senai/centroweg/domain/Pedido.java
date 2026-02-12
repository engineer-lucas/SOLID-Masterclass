package br.com.senai.centroweg.domain;

public class Pedido {
    private String id;
    private double valorTotal;
    private int quantidadeItens;
    private String emailCliente;
    private boolean isPago;

    public Pedido(String id, double valorTotal, int quantidadeItens, String emailCliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.quantidadeItens = quantidadeItens;
        this.emailCliente = emailCliente;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public int getQuantidadeItens() {
        return quantidadeItens;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public void setPago(boolean pago) {
        isPago = pago;
    }
}
