package br.com.senai.centroweg.repository;
import br.com.senai.centroweg.domain.Pedido;
public class PedidoRepository {
    public void salvar(Pedido pedido, double valorFinal){
        System.out.println("Salvando pedido " + pedido.getId() + " no Banco de Dados. Valor: R$ " + valorFinal);
    }
}
