package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
/**
 * Camada de Serviço: Responsável pela validação de regras de negócio.
 * Seguindo o Princípio da Responsabilidade Única (SRP), esta classe
 * cuida exclusivamente da verificação de disponibilidade física (Estoque).
 */
public class ValidadorEstoque {
    /**
     * Valida se há estoque suficiente para processar o pedido.
     * Esta é a Responsabilidade 1 identificada no sistema legado.
     * * @param pedido O objeto contendo a quantidade de itens solicitada.
     * @throws Exception Disparada caso a quantidade exceda o limite operacional.
     */
    public void validar(Pedido pedido) throws Exception {
        // Regra de Negócio: A TechStore não permite pedidos acima de 100 itens por vez.
        if (pedido.getQuantidadeItens() > 100) {
            // Se a regra for violada, o processo é interrompido com uma exceção.
            throw new Exception("Estoque Insuficiente!");
        }
        // Se passar pelo IF, o sistema entende que o estoque está OK.
        System.out.println("Estoque validado com sucesso para o pedido: " + pedido.getId());
    }
}