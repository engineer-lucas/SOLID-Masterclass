package br.com.senai.centroweg.notification;

public class EmailService {
    public void enviarConfirmacao(String email, String idPedido){
        System.out.println("Email enviado para: " + email + " | Pedido: " + idPedido);
    }
}
