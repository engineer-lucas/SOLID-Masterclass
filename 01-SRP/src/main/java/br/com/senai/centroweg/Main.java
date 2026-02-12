package br.com.senai.centroweg;
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.service.ServicoPedido;

public class Main {
    public static void main(String[] args) {
// 1. Criar um pedido de teste (Cenário de sucesso)
// ID, Valor Bruto, Quantidade, Email
    Pedido pedidoValido = new Pedido("PED-123", 600.00, 5, "cliente@email.com");
// 2. Instanciar o orquestrador (Serviço)
    ServicoPedido servico = new ServicoPedido();

        System.out.println("--- Iniciando Processamento de Pedido ---");

        try {
            // 3. Executar o fluxo completo
            servico.processar(pedidoValido);
            System.out.println("--- Processamento Finalizado com Sucesso ---");

        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

// 4. Testar o Cenário de Erro (Violação de Estoque > 100)
        Pedido pedidoInvalido = new Pedido("PED-ERROR", 1000.00, 150, "admin@techstore.com");

        System.out.println("\n--- Testando Validação de Estoque (Deve falhar) ---");
        try {
            servico.processar(pedidoInvalido);
        } catch (Exception e) {
            System.out.println("Capturado erro esperado: " + e.getMessage());
        }
    }
}
