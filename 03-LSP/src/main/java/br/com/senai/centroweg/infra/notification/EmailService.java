package br.com.senai.centroweg.infra.notification;

public class EmailService {
    public void enviar(String mensagem) {
        System.out.println("[INFRA-EMAIL] Enviando: " + mensagem);
    }
}
