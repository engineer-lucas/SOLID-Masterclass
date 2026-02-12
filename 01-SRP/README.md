Para criar um `README.md` profissional para este projeto, o texto deve explicar o problema original (a violação do SRP) e como a nova estrutura resolve isso através da arquitetura em camadas.

Aqui está um modelo que você pode copiar e colar no seu arquivo:

---

# 🚀 SOLID Masterclass: Princípio da Responsabilidade Única (SRP)

Este repositório contém a implementação prática da **Atividade 1** da unidade curricular de **Arquitetura de Sistemas**. O objetivo é demonstrar a refatoração de um sistema legado para atender ao primeiro princípio do SOLID: **SRP (Single Responsibility Principle)**.

## 📝 Cenário: TechStore - Gerenciamento de Pedidos

A empresa fictícia **TechStore** utilizava uma única classe, a `ProcessadorDePedido`, para lidar com todo o ciclo de vida de um pedido. Essa classe era instável e de alto risco, pois qualquer mudança em regras de frete ou pagamento obrigava a alteração do seu código interno.

### ❌ O Problema (Violação do SRP)

A classe original assumia quatro responsabilidades distintas:

1.
**Validação de Estoque**: Verificação da disponibilidade dos itens.


2.
**Cálculo de Domínio**: Lógica complexa de frete e impostos.


3.
**Persistência**: Comunicação com o banco de dados.


4.
**Notificação**: Integração com serviços de e-mail.



---

## ✅ A Solução (SRP Aplicado)

A solução foi refatorada separando as responsabilidades em classes especializadas, organizadas por camadas de arquitetura:

### 📂 Estrutura de Pacotes

*
**`domain`**: Contém a entidade `Pedido`, que lida apenas com os dados fundamentais do negócio.


* **`services`**: Contém as classes de lógica de negócio:
*
`ValidadorEstoque`: Responsável exclusivamente pela validação.


*
`CalculadoraFinanceira`: Responsável pelos cálculos de frete e impostos.


*
`ServicoDePedido`: Classe de orquestração que coordena o fluxo sem conhecer os detalhes de implementação de cada etapa.




*
**`repository`**: Contém o `PedidoRepository`, responsável pela persistência dos dados.


*
**`notifications`**: Contém o `EmailService`, responsável pela comunicação externa com o cliente.



---

## 🛠️ Como Executar

1. Certifique-se de ter o **Java 22** e o **Maven** configurados.
2. Navegue até o módulo `01-SRP`.
3. Execute a classe `Main.java` localizada no pacote raiz `br.com.senai.centroweg`.

### Saída Esperada no Console:

Ao processar um pedido válido, o console demonstrará a interação entre as classes:

* Confirmação de salvamento no Banco de Dados.
* Log de envio de e-mail de confirmação.
* Cálculo final incluindo frete e 15% de impostos.



---

## 🎓 Importância para o E-commerce

Esta separação é crucial pois permite que o sistema cresça de forma sustentável. Se a TechStore trocar o serviço de e-mail ou o banco de dados, apenas a classe específica será alterada, garantindo que a regra de cálculo financeiro permaneça intacta e segura.

---

**Professor:** Lucas Santos

**Instituição:** SENAI - Centro WEG

---

### Dica para os Alunos:

No GitHub Desktop, após criar este arquivo:

1. Escreva `docs: adicionando README explicativo` no campo Summary.
2. Clique em **Commit to main**.
3. Clique em **Push origin**.