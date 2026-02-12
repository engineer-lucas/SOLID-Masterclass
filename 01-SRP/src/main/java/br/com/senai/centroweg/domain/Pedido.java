package br.com.senai.centroweg.domain;

/**
 * Camada de Domínio: Representa a entidade Pedido.
 * Seguindo o SRP (Princípio da Responsabilidade Única), esta classe
 * possui apenas a responsabilidade de representar os dados do pedido,
 * sem carregar lógicas de validação, cálculo ou persistência.
 */
public class Pedido {

    // Atributos privados para garantir o encapsulamento dos dados
    private String id;
    private double valorTotal;
    private int quantidadeItens;
    private String emailCliente;
    private boolean isPago; // Status que será alterado pelo Serviço de Pedido

    /**
     * Construtor para inicializar um novo pedido.
     * @param id Identificador único do pedido.
     * @param valorTotal Valor bruto dos produtos.
     * @param quantidadeItens Quantidade de itens para verificação de estoque.
     * @param emailCliente Destinatário das notificações de confirmação.
     */
    public Pedido(String id, double valorTotal, int quantidadeItens, String emailCliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.quantidadeItens = quantidadeItens;
        this.emailCliente = emailCliente;
        this.isPago = false; // Por padrão, o pedido inicia como não pago
    }

    // --- Métodos Getters e Setters ---
    // Permitem o acesso controlado aos dados do objeto

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

    /**
     * Define o status de pagamento do pedido.
     * Este método será utilizado pelo Serviço de Orquestração após o processamento.
     */
    public void setPago(boolean pago) {
        isPago = pago;
    }
}