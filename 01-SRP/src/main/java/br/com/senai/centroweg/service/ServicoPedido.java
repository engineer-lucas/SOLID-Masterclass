package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.repository.PedidoRepository;
import br.com.senai.centroweg.notification.EmailService;

public class ServicoPedido {
    private ValidadorEstoque validador = new ValidadorEstoque();
    private CalculadoraFinanceira calculadora = new CalculadoraFinanceira();
    private PedidoRepository repositorio = new PedidoRepository();
    private EmailService email = new EmailService();

    public void processar(Pedido pedido) throws Exception{
        validador.validar(pedido);
        double total = calculadora.calcularTotal(pedido);
        pedido.setPago(true);
        repositorio.salvar(pedido, total);
        email.enviarConfirmacao(pedido.getEmailCliente(), pedido.getId());
    }
}
