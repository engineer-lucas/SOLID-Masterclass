package br.com.senai.centroweg.notification;
/**
 * Camada de Notificação: Responsável exclusivamente pela comunicação externa.
 * * Seguindo o SRP, se a TechStore decidir parar de usar E-mail e passar a usar
 * SMS ou WhatsApp, apenas esta camada/classe sofrerá alterações[cite: 10, 16].
 */
public class EmailService {
    /**
     * Envia um e-mail de confirmação para o cliente.
     * * Esta é a Responsabilidade 4 identificada no cenário: Integração externa[cite: 16].
     * No código original, essa lógica estava "misturada" com o cálculo de frete[cite: 17].
     * * @param email Endereço do cliente (extraído do objeto Pedido).
     * @param idPedido Identificador único para referência na mensagem.
     */
    public void enviarConfirmacao(String email, String idPedido) {
        // Simulação de integração com um servidor de e-mail (Ex: SendGrid ou Mailgun) [cite: 17]
        System.out.println("Email enviado para: " + email + " | Pedido: " + idPedido);
    }
}