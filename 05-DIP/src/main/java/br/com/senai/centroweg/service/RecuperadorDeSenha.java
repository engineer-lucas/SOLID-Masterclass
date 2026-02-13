package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.service.IComunicador;
public class RecuperadorDeSenha {
    private final IComunicador comunicador; // Depende da abstração]

    // Injeção de Dependência via Construtor
    public RecuperadorDeSenha(IComunicador comunicador) {
        this.comunicador = comunicador;
    }

    public void recuperar(String destino) {
        String link = "http://techstore.com/reset?token=abc-123";
        String mensagem = "Clique no link para resetar sua senha: " + link;

        System.out.println("[SERVICE] Iniciando processo de recuperação para: " + destino);
        comunicador.enviar(mensagem);
    }
}
