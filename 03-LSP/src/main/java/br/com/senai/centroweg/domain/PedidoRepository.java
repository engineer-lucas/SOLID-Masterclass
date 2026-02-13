package br.com.senai.centroweg.domain;

public interface PedidoRepository {
    void salvar(Pedido pedido, double valorFinal);
}
