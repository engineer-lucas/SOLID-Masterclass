package br.com.senai.centroweg;
//Importando as classes das outras camadas
import br.com.senai.centroweg.domain.Pedido;
import br.com.senai.centroweg.services.CalculadoraDesconto;
import br.com.senai.centroweg.strategies.DescontoAniversario;
import br.com.senai.centroweg.strategies.DescontoCupom;
import br.com.senai.centroweg.strategies.DescontoVip;

public class Main {
    public static void main(String[] args) {
        // 1. Criamos um pedido conforme o cenário da TechStore
    Pedido meuPedido = new Pedido("TS-001", 1000.0);
        // 2. Instanciamos o serviço (Calculadora)
    CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();
        // 3. Demonstramos o OCP: Passamos a estratégia desejada como argumento [cite: 96, 99]
        // Testando o Desconto de Cupom (10%)
    double comCupon = calculadoraDesconto.aplicar(meuPedido, new DescontoCupom());
        // Testando o NOVO Desconto de Aniversário (20%)
    double comAniversario = calculadoraDesconto.aplicar(meuPedido, new DescontoAniversario());
       //Testando o NOVO desconto de Vip (15%)
    double comVip = calculadoraDesconto.aplicar(meuPedido, new DescontoVip());

    //Exibindo os resultado
        System.out.println("===================================================");
        System.out.println("Valor Original: R$ " + meuPedido.getValorBruto());
        System.out.println("Valor com DESCONTO DE CUPOM: R$ " + comCupon);
        System.out.println("Valor com DESCONTO DE ANIVERSÁRIO: R$ " + comAniversario);
        System.out.println("Valor com DESCONTO DE VIP: R$ " + comVip);
        System.out.println("===================================================");
    }
}
