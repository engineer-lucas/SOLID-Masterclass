package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
public class ValidadorEstoque {
    public static void validar(Pedido pedido) throws Exception {
        if (pedido.getQuantidadeItens() > 100) {
            throw new Exception("Estoque Insuficiente!");
        }
    }
}
