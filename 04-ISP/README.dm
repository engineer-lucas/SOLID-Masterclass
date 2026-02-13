# 🧩 Módulo 04: Princípio da Segregação de Interfaces (ISP)

Este módulo demonstra a refatoração de um sistema de gestão de clientes para cumprir o **ISP**, eliminando dependências desnecessárias.

## ❌ O Mau Design (Violação do ISP)
A interface `GerenciadorDeClientes` era "obesa" por agrupar operações de cadastro, comunicação e fidelidade em um único contrato. [cite_start]Isso forçava o `ClienteComumService` a implementar métodos como `aplicarDescontoVIP`, resultando em exceções `UnsupportedOperationException` e código "sujo"[cite: 11, 21].

## ✅ A Solução (Segregação)
[cite_start]Refatoramos a interface monolítica em três interfaces coesas: `ICadastroCliente`, `INotificador` e `IGerenciadorFidelidade`[cite: 26].

### Benefícios:
- **Segurança:** O compilador impede o uso de métodos VIP em clientes comuns.
- **Coesão:** Cada interface tem uma responsabilidade única e clara.
- **Flexibilidade:** Facilita a manutenção e expansão futura do sistema.