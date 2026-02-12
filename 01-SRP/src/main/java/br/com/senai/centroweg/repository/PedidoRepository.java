package br.com.senai.centroweg.repository;
import br.com.senai.centroweg.domain.Pedido;
/**
 * Camada de Persistência (Repository): Responsável pela comunicação com o Banco de Dados.
 * * Seguindo o SRP (Princípio da Responsabilidade Única), esta classe isola a lógica
 * de armazenamento (Responsabilidade 3 do cenário TechStore)[cite: 15, 19].
 */
public class PedidoRepository {

    /**
     * Simula a persistência de um pedido finalizado no banco de dados.
     * * O benefício desta separação é que, se a empresa trocar de banco (ex: de MySQL para NoSQL),
     * apenas esta classe será alterada, sem risco de afetar cálculos ou notificações[cite: 10, 15].
     * * @param pedido O objeto da entidade Pedido que será persistido.
     * @param valorFinal O valor total já calculado com frete e impostos.
     */
    public void salvar(Pedido pedido, double valorFinal) {
        // No futuro, aqui estaria o código JDBC, JPA ou integração com APIs de banco de dados
        System.out.println("Salvando pedido " + pedido.getId() + " no Banco de Dados. Valor: R$ " + valorFinal);
    }
}