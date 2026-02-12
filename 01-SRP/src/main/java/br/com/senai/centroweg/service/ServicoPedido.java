package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.repository.PedidoRepository;
import br.com.senai.centroweg.notification.EmailService;
/**
 * Classe de Orquestração (Serviço): Coordena o fluxo de processamento do pedido.
 * Esta classe resolve a violação do SRP ao delegar cada responsabilidade para
 * sua respectiva classe especializada.
 */
public class ServicoPedido {
    // Instanciação das classes especializadas (cada uma com sua responsabilidade única)
    private ValidadorEstoque validador = new ValidadorEstoque(); // Responsabilidade 1
    private CalculadoraFinanceira calculadora = new CalculadoraFinanceira(); // Responsabilidade 2
    private PedidoRepository repositorio = new PedidoRepository(); // Responsabilidade 3
    private EmailService email = new EmailService(); // Responsabilidade 4
    /**
     * Orquestra as etapas necessárias para finalizar um pedido na TechStore.
     * @param pedido O objeto a ser processado.
     * @throws Exception Caso a validação de estoque falhe.
     */
    public void processar(Pedido pedido) throws Exception {
        // 1. Delega a validação de estoque
        validador.validar(pedido);

        // 2. Delega o cálculo de frete e impostos
        double total = calculadora.calcularTotal(pedido);

        // 3. Atualiza o estado da entidade de domínio
        pedido.setPago(true);

        // 4. Delega a persistência dos dados
        repositorio.salvar(pedido, total);

        // 5. Delega o envio da notificação ao cliente
        email.enviarConfirmacao(pedido.getEmailCliente(), pedido.getId());
    }
}
