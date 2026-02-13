package br.com.senai.centroweg;
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.infra.repositories.PedidoDataBaseRepository;
import br.com.senai.centroweg.service.ProcessadorDePagamento;
import br.com.senai.centroweg.service.strategies.FreteGratis;
import br.com.senai.centroweg.service.strategies.FretePadrao;

public class main {
    public static void main(String[] args) {
        // 1. Inicializamos a Infraestrutura
        PedidoDataBaseRepository bancoDeDados = new PedidoDataBaseRepository();

        // 2. Inicializamos o Serviço injetando a infra (Dependency Injection)
        ProcessadorDePagamento processador = new ProcessadorDePagamento(bancoDeDados);

        // 3. Criamos um pedido
        Pedido pedido1 = new Pedido("PED-789", 1000.0);

        // 4. Demonstração de LSP: trocamos a estratégia sem mudar o serviço
        System.out.println("--- Teste com Frete Padrão ---");
        processador.processar(pedido1, new FretePadrao());

        System.out.println("\n--- Teste com Frete Grátis ---");
        processador.processar(pedido1, new FreteGratis());
    }
}
