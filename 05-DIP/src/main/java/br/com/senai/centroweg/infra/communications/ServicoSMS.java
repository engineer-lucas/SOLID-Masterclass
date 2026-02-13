package br.com.senai.centroweg.infra.communications;
import br.com.senai.centroweg.domain.service.IComunicador;
public class ServicoSMS implements IComunicador{
    @Override
    public void enviar(String mensagem) {
        System.out.println("[INFRA] Enviando SMS via Gateway: " + mensagem);
    }
}
