package br.com.senai.centroweg.domain;

public interface ICadastroCliente {
    void cadastrar(String nome, String email);
    String buscarPorEmail(String email);
}
