package br.com.senai.centroweg;

import br.com.senai.centroweg.domain.ICadastroCliente;
import br.com.senai.centroweg.domain.IFidelidade;
import br.com.senai.centroweg.domain.INotificador;
import br.com.senai.centroweg.service.ClienteComumService;
import br.com.senai.centroweg.service.ClienteVIPService;

public class main {
    public static void main(String[] args) {
        System.out.println("=== TECHSTORE: GESTÃO DE CLIENTES (ISP) ===\n");

        // 1. Cenário Cliente Comum
        // Note que usamos a interface específica. O objeto 'comum' NÃO tem acesso a notificações ou descontos.
        ICadastroCliente comum = new ClienteComumService();
        comum.cadastrar("João Silva", "joao@email.com");
        System.out.println(comum.buscarPorEmail("joao@email.com"));

        System.out.println("\n------------------------------------------\n");

        // 2. Cenário Cliente VIP
        // O VIP pode ser assinado pelas 3 interfaces, pois ele implementa todas.
        ClienteVIPService vip = new ClienteVIPService();

        // Operações de Cadastro
        vip.cadastrar("Maria Souza", "maria.vip@email.com");

        // Operação de Notificação (Exclusiva do contrato INotificador)
        vip.enviarNotificacao("maria.vip@email.com", "Bem-vinda ao clube Gold!");

        // Operação de Fidelidade (Exclusiva do contrato IFidelidade)
        vip.aplicarDescontoVIP("maria.vip@email.com", 15.0);

        System.out.println("\n=== SUCESSO: ISP APLICADO COM SEGURANÇA ===");
    }
}