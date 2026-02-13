package br.com.senai.centroweg.infra.communications;
import br.com.senai.centroweg.domain.service.IComunicador;

public class ServiceEmail implements IComunicador{
    @Override
    public void enviar(String mensagem) {
        System.out.println("[INFRA] Enviando E-mail SMTP: " + mensagem);
    }
}
