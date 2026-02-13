package br.com.senai.centroweg.infra.repositories;

import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.domain.PedidoRepository;

public class PedidoDataBaseRepository implements PedidoRepository {

    @Override
    public void salvar(Pedido pedido, double valorFinal) {
        // Aqui entraria a conexão real com MySQL, MongoDB, etc.
        System.out.println("[INFRA] Conectando ao Banco de Dados...");
        System.out.println("[INFRA] Pedido " + pedido.getId() + " salvo com valor final: R$ " + valorFinal);
    }
}
