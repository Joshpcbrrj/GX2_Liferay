# Documentação da API REST SolicitacaoServico

## Descrição
Este módulo fornece uma API REST para gerenciar solicitações de serviço de clientes corporativos. A API permite realizar operações como criar, atualizar, consultar e listar solicitações de serviço, com os dados retornados no formato JSON.

---

### URL base

```bash
http://localhost:8080/api/o/solicitacao-servico-api
```
<br>

## Endpoints:

### 1 - Adicionar uma nova Solicitação de Serviço

- **Método:** POST
- **Rota:** `http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes`
- **Descrição:** Adiciona uma nova solicitação de serviço ao sistema.

#### Parâmetros de Entrada (JSON): 
- `clientePJId` (long): ID do cliente corporativo (Pessoa Jurídica).
- `codigoUnimed` (String): Código Unimed relacionado à solicitação.
- `descricao` (String): Descrição da solicitação.
- `status` (int): Status da solicitação.
- `prioridade` (int): Prioridade da solicitação.

**Exemplo de Requisição:**

```bash
POST http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes
```

**Corpo (JSON):**

```bash
{
  "clientePJId": 1,
  "codigoUnimed": "123456",
  "descricao": "Solicitação de novo serviço",
  "status": 1,
  "prioridade": 2
}
```

**Exemplo de Resposta (JSON):**

```bash
{
  "solicitacaoId": 1,
  "codigoUnimed": "123456",
  "descricao": "Solicitação de novo serviço",
  "dataSolicitacao": "19/10/2024",
  "status": "PENDENTE",
  "prioridade": "ALTA",
  "clientePJId": 1
}
```

**Possíveis Respostas de Erro:**
* Código 400: Descrição não pode ser nula ou vazia.
* Código 500: Erro interno ao adicionar a solicitação de serviço.

<br>

### 2 - Atualizar uma Solicitação de Serviço pelo ID

- **Método:** PUT
- **Rota:** `http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/{solicitacaoId}`
- **Parâmetro de Caminho:** solicitacaoId (long): ID da solicitação a ser atualizada.
- **Descrição:** Atualiza os dados de uma solicitação de serviço existente.

#### Parâmetros de Entrada (JSON): 
- `codigoUnimed` (String): Novo código Unimed da solicitação.
- `descricao` (String): Nova descrição da solicitação.
- `status` (int): Novo status da solicitação.
- `prioridade` (int): Nova prioridade da solicitação


**Exemplo de Requisição:**

```bash
PUT http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/1
```

**Corpo (JSON):**

```bash
{
  "codigoUnimed": "654321",
  "descricao": "Atualização de solicitação",
  "status": 2,
  "prioridade": 3
}
```

**Exemplo de Resposta (JSON):**

```bash
{
  "solicitacaoId": 1,
  "codigoUnimed": "654321",
  "descricao": "Atualização de solicitação",
  "dataSolicitacao": "19/10/2024",
  "status": "CONCLUÍDO",
  "prioridade": "MÉDIA",
  "clientePJId": 1
}
```

**Possíveis Respostas de Erro:**
* Código 400: Descrição não pode ser nula ou vazia.
* Código 404: Solicitação de serviço não encontrada.
* Código 500: Erro interno ao atualizar a solicitação de serviço.

<br>

### 3 - Buscar uma Solicitação de Serviço pelo ID

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/{solicitacaoId}`
- **Parâmetro de Caminho:** `solicitacaoId` (long): ID da solicitação a ser buscada.
- **Descrição:** Retorna os dados de uma solicitação de serviço existente no sistema.

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "solicitacaoId": 1,
  "codigoUnimed": "123456",
  "descricao": "Solicitação de novo serviço",
  "dataSolicitacao": "19/10/2024",
  "status": "PENDENTE",
  "prioridade": "ALTA",
  "clientePJId": 1
}
```

**Possíveis Respostas de Erro:**
* Código 404: Solicitação de serviço não encontrada.
* Código 500: Erro interno ao buscar a solicitação de serviço.

<br>

### 4 - Recuperar todas as Solicitações de Serviço

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes`
- **Descrição:** Retorna uma lista com todas as solicitações de serviço cadastradas no sistema.

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes
```

**Exemplo de Resposta (JSON):**

```bash
[
  {
    "solicitacaoId": 1,
    "codigoUnimed": "123456",
    "descricao": "Solicitação de novo serviço",
    "dataSolicitacao": "19/10/2024",
    "status": "PENDENTE",
    "prioridade": "ALTA",
    "clientePJId": 1
  },
  {
    "solicitacaoId": 2,
    "codigoUnimed": "654321",
    "descricao": "Atualização de solicitação",
    "dataSolicitacao": "18/10/2024",
    "status": "CONCLUÍDO",
    "prioridade": "MÉDIA",
    "clientePJId": 2
  }
]
```

**Possíveis Respostas de Erro:**
* Código 500: Erro interno ao recuperar as solicitações de serviço.

<br>

### 5 - Deletar uma Solicitação de Serviço pelo ID

- **Método:** DELETE
- **Rota:** `http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/{solicitacaoId}`
- **Parâmetro de Caminho:** `solicitacaoId` (long): ID da solicitação a ser deletada.
- **Descrição:** Remove uma solicitação de serviço existente no sistema.

**Exemplo de Requisição:**

```bash
DELETE http://localhost:8080/api/o/solicitacao-servico-api/solicitacoes/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "message": "Solicitação de serviço deletada com sucesso.",
  "solicitacaoId": 1
}
```

**Possíveis Respostas de Erro:**
* Código 404: Solicitação de serviço não encontrada.
* Código 500: Erro interno ao deletar a solicitação de serviço.

<br>

<br>
<br>
<br>

[Voltar para página do desafio](/Conteudo_rockets/Desafio3/Desafio3.md)
[Voltar para o inicio](/README.md)