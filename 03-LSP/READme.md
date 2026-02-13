# 📦 TechStore: Sistema de Processamento de Pedidos (Módulo 03 - LSP)

Este módulo apresenta a solução definitiva para o problema de cálculo de frete da TechStore, aplicando o **Princípio da Substituição de Liskov (LSP)** através de uma **Arquitetura em Camadas** e o padrão de projeto **Strategy**.

## 🏗️ Estrutura do Projeto (Arquitetura em Camadas)

O projeto foi organizado seguindo a separação de responsabilidades proposta por Robert C. Martin (*Clean Code*), garantindo que o núcleo do negócio seja independente de tecnologias externas.



### Hierarquia de Pastas:
```text
src/main/java/br/com/senai/centroweg/
│
├── domain/                  # O Coração: Entidades e Contratos (Interfaces)
│   ├── Pedido.java
│   ├── EstrategiaDeFrete.java
│   └── PedidoRepository.java (Interface)
│
├── service/                 # A Inteligência: Regras de Negócio e Orquestração
│   ├── ProcessadorDePagamento.java
│   └── strategies/          # Lógica que varia (Strategy Pattern)
│       ├── FretePadrao.java
│       └── FreteGratis.java
│
├── infra/                   # A Mão de Obra: Detalhes Técnicos e Ferramentas
│   ├── repositories/        # Persistência real (ex: SQL Server, MySQL)
│   ├── notifications/       # Serviços de apoio (E-mail, SMS, WhatsApp)
│   └── config/              # Configurações globais e de frameworks
│
└── Main.java                # Ponto de entrada (Application)

```
✅ A Solução Profissional (Refatoração)
1. Padrão Strategy (Estratégias de Cálculo)
Em vez de herança, usamos composição. O cálculo agora é uma estratégia externa. Isso permite que novas regras de frete sejam criadas apenas adicionando novas classes, sem mexer na entidade Pedido (Princípio Aberto/Fechado).

2. Injeção de Dependência e Desacoplamento de Infra
O ProcessadorDePagamento não conhece o Banco de Dados real. Ele recebe a interface PedidoRepository.

Isso permite trocar o banco de dados na pasta infra sem alterar uma única linha da lógica de negócio na pasta service.

3. Garantia do LSP
As classes FretePadrao e FreteGratis implementam o mesmo contrato (EstrategiaDeFrete). O ProcessadorDePagamento pode alternar entre elas com total confiança de que ambas retornarão um valor válido para o fluxo financeiro.

🚀 Como Executar
Certifique-se de que a estrutura de pastas descrita acima foi criada manualmente.

Execute a classe Main.java.

Observe o terminal: ele demonstrará o fluxo passando pela Service (Orquestração), chamando a Strategy (Cálculo) e finalizando na Infra (Persistência).



Log Esperado:
--- Teste com Frete Padrão ---
[SERVICE] Processando pedido PED-789
[INFRA] Conectando ao Banco de Dados...
[INFRA] Pedido PED-789 salvo com valor final: R$ 1050.0

--- Teste com Frete Grátis ---
[SERVICE] Processando pedido PED-789
[INFRA] Conectando ao Banco de Dados...
[INFRA] Pedido PED-789 salvo com valor final: R$ 1000.0


Na prática, o **Liskov Substitution Principle (LSP)** acontece no momento em que o seu código para de fazer perguntas sobre "quem" é o objeto e passa a apenas "confiar" no que ele faz.

No seu projeto da **TechStore**, vemos o LSP em ação exatamente nestes três pontos práticos:

### 1. No "Intercambiamento" sem Erros (O momento do teste)

A prova real do LSP é quando você olha para a sua classe `Main` e percebe que pode trocar uma classe por outra e o resultado continua sendo logicamente correto.

```java
// Se eu passar FretePadrao, o sistema funciona.
processador.processar(meuPedido, new FretePadrao()); 

// Se eu substituir por FreteGratis, o sistema CONTINUA funcionando 
// e não lança nenhuma Exception inesperada.
processador.processar(meuPedido, new FreteGratis()); 

```

**Na prática:** Se o `FreteGratis` fizesse o sistema travar ou retornasse um valor negativo (quebrando a lógica de um "valor final"), o LSP estaria sendo violado.

### 2. Na ausência de `if` e `instanceof` (Código Limpo)

Um sinal claro de que você **NÃO** está usando o LSP é quando você vê códigos assim:

```java
// ISSO É VIOLAÇÃO DE LSP (E OCP)
if (pedido instanceof PedidoComFreteGratis) {
    // faz algo especial porque a herança quebrou o padrão
}

```

**Na prática:** No seu `ProcessadorDePagamento` refatorado, você não tem nenhum `if`. Você apenas chama `estrategia.calcularValorFinal(pedido)`. O fato de o processador tratar todas as estratégias de forma idêntica, e elas responderem corretamente, é o LSP funcionando.

### 3. No Respeito aos Contratos (Pós-condições)

O LSP diz que as subclasses não podem "entregar menos" do que a classe base prometeu.

* **A promessa (Interface):** Vou receber um pedido e devolver um `double` (valor final).
* **A realidade (FreteGratis):** Ele recebe o pedido e devolve o valor bruto (um `double` válido). Ele não "quebra" o cálculo, ele apenas executa uma variação permitida.

### Resumo para explicar aos alunos:

O LSP acontece na prática quando a **abstração é confiável**.

Imagine um controle remoto universal (Interface): ele tem o botão "Ligar".

* Se você apontar para uma TV Sony e apertar, ela liga.
* Se você trocar a TV por uma da Samsung (Substituição) e apertar o mesmo botão, ela também deve ligar.
* **Violação de LSP:** Se ao trocar pela Samsung, o botão "Ligar" passasse a aumentar o volume ou desse erro, o princípio estaria quebrado, pois o objeto substituto não honrou o comportamento esperado do original.

**No seu código, o `ProcessadorDePagamento` é o controle remoto, e as `Strategies` de frete são as diferentes marcas de TV que ele controla sem precisar saber qual é qual.**