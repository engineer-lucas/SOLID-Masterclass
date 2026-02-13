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