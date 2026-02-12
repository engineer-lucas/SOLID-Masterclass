package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
/**
 * Camada de Serviço: Responsável pelas regras de negócio financeiras.
 * Seguindo o SRP (Princípio da Responsabilidade Única), esta classe
 * isola a lógica de cálculos complexos de domínio[cite: 14, 20].
 */
public class CalculadoraFinanceira {
    /**
     * Realiza o cálculo do montante final do pedido, incluindo frete e impostos.
     * Esta é a Responsabilidade 2 identificada: Cálculo de Domínio Complexo.
     * * @param pedido O objeto pedido contendo o valor base para o cálculo.
     * @return O valor total final após a aplicação das taxas.
     */
    public double calcularTotal(Pedido pedido) {
        // Regra de Frete: Grátis para pedidos acima de R$ 500,00, caso contrário R$ 50,00[cite: 17].
        double frete = (pedido.getValorTotal() < 500.00) ? 50.00 : 0.0;

        // Regra de Impostos: Aplicação de uma taxa fixa de 15% sobre o valor total[cite: 17].
        double impostos = pedido.getValorTotal() * 0.15;

        // Retorna a soma do valor base, frete e impostos[cite: 17].
        return pedido.getValorTotal() + frete + impostos;
    }
}