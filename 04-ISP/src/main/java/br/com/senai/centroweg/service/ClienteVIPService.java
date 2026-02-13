package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.*;
public class ClienteVIPService implements ICadastroCliente, INotificador, IFidelidade{

    @Override
    public void cadastrar(String nome, String email) {
        System.out.println("[VIP] Cadastrando: " + nome);
    }

    @Override
    public String buscarPorEmail(String email) {
        return "[VIP] Cliente " + email + " encontrado.";
    }

    @Override
    public void aplicarDescontoVIP(String email, double mensagem) {
        System.out.println("[VIP] Notificação enviada para: " + email);
    }

    @Override
    public void enviarNotificacao(String email, String percentual) {
        System.out.println("[VIP] Desconto de " + percentual + "% aplicado.");
    }
}
