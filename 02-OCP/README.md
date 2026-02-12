📘 Explicação para os Alunos: Por que essa estrutura?
Enquanto eles criam, você pode explicar o Mau Design que estamos corrigindo:

O Problema Original: O código inicial usava if/else na CalculadoraDeDesconto para verificar o tipo de desconto. Isso obrigava a modificar a classe toda vez que o marketing criava uma nova promoção, violando o OCP.

A Solução: Criamos uma Interface que funciona como um "contrato". Agora, a Calculadora apenas recebe esse contrato e o executa, sem saber (e sem precisar mudar) qual é a regra específica por trás dele.


Estrutura dos Módulos (Subprojetos)
Cada pasta como a 02-OCP é um projeto independente. Dentro de cada uma, você deve criar (ou já possui) esta estrutura padrão:

**1. src/main/java**
   Esta é a pasta mais importante. É aqui que o código-fonte que vai para produção reside. Dentro dela, dividimos as Camadas:

**domain (Domínio):**

- Responsabilidade: Contém as regras de ouro e os modelos. Aqui ficam as Interfaces (os contratos) e as Entidades (classes que representam dados, como Pedido ou Produto).

- Por que? Se você mudar o banco de dados ou a interface visual, as regras de domínio não mudam.

**strategies (Estratégias/Implementações):**

- Responsabilidade: No caso do OCP, aqui ficam as implementações específicas (ex: FreteSedex, FreteDrone).

- Por que? Elas são "peças encaixáveis" que seguem o contrato do domínio.

**services (Serviços/Aplicação):**

- Responsabilidade: Coordena as ações. É o "maestro" que recebe um pedido, escolhe uma estratégia e executa a lógica. É aqui que o Princípio do Aberto-Fechado é aplicado para evitar o uso de if/else.


**2. src/main/resources**
   Responsabilidade: Guarda arquivos que não são código Java, como fotos, arquivos de configuração .properties, arquivos .xml ou configurações de banco de dados.

**3. src/test**
   Responsabilidade: Onde moram os testes unitários (JUnit). É vital no SOLID, pois após refatorar para OCP, você roda os testes aqui para garantir que não quebrou nada.
   +1

📝 Resumo para a lousa:
"O Projeto Pai organiza a casa, o Módulo isola o conhecimento de cada princípio, e as Camadas (Domain/Service) garantem que uma mudança em como calculamos o frete não obrigue a reescrever o sistema inteiro."

java
└── br.com.senai.centroweg
├── domain (pacote com Pedido e Interface)
├── services (pacote com a Calculadora)
├── strategies (pacote com as regras de desconto)
└── Main.java  <-- ELA FICA AQUI (fora das subpastas)