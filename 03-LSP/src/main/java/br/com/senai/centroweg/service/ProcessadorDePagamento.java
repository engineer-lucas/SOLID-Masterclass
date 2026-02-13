package br.com.senai.centroweg.service;
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.domain.EstrategiaDeFrete;
import br.com.senai.centroweg.domain.PedidoRepository;

public class ProcessadorDePagamento {
    private final PedidoRepository repositorio;

    // Injeção de Dependência: o serviço não sabe QUAL banco de dados está sendo usado
    public ProcessadorDePagamento(PedidoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void processar(Pedido pedido, EstrategiaDeFrete estrategia) {
        // Delega o cálculo para a estratégia recebida (LSP na prática)
        double valorFinal = estrategia.calcularValorFinal(pedido);

        System.out.println("[SERVICE] Processando pedido " + pedido.getId());
        repositorio.salvar(pedido, valorFinal);
    }

}
