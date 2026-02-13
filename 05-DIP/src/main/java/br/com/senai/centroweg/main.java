package br.com.senai.centroweg;
import br.com.senai.centroweg.domain.service.IComunicador;
import br.com.senai.centroweg.infra.communications.ServiceEmail;
import br.com.senai.centroweg.infra.communications.ServicoSMS;
import br.com.senai.centroweg.service.RecuperadorDeSenha;

public class main {
    public static void main(String[] args) {
        // Teste com E-mail
        IComunicador email = new ServiceEmail();
        RecuperadorDeSenha recuperadorEmail = new RecuperadorDeSenha(email);
        recuperadorEmail.recuperar("usuario@techstore.com");

        System.out.println("\n--- TROCANDO A TECNOLOGIA SEM ALTERAR O SERVICE ---\n");

        // Teste com SMS (Mesmo Service, dependência diferente)
        IComunicador sms = new ServicoSMS();
        RecuperadorDeSenha recuperadorSMS = new RecuperadorDeSenha(sms);
        recuperadorSMS.recuperar("(47) 99999-9999");
    }
}
