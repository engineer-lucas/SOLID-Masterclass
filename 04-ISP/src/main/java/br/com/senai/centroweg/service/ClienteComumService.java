package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.ICadastroCliente;
public class ClienteComumService implements ICadastroCliente{
    @Override
    public void cadastrar(String nome, String email) {
        System.out.println("[COMUM] Cadastrando: " + nome);
    }
    @Override
    public String buscarPorEmail(String email) {
        return "[COMUM] Cliente \" + email + \" encontrado.";
    }
}
