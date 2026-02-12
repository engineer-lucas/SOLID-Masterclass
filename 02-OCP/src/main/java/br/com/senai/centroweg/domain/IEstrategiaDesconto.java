package br.com.senai.centroweg.domain;
//Interface IEstrategiaDesconto.java Esta é a solução para o desafio. Ela define o que todo desconto deve saber fazer.
public interface IEstrategiaDesconto {
    double calcular(Pedido pedido);
}
