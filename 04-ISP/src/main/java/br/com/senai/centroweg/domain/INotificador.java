package br.com.senai.centroweg.domain;

public interface INotificador {
    void enviarNotificacao(String email, String mensagem);
}
