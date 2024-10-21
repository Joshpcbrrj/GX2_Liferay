# Documentação da API REST Auditoria

## Descrição
Este módulo fornece uma API REST para gerenciar entradas de auditoria relacionadas a acessos. A API permite realizar operações como adicionar, deletar, consultar e listar auditorias, com os dados retornados no formato JSON.

---

### URL base

```bash
http://localhost:8080/api/o/auditoria
```
<br>

## Endpoints:

### 1 - Adicionar uma nova Entrada de Auditoria

- **Método:** POST
- **Rota:** `http://localhost:8080/api/o/auditoria/auditorias`
- **Descrição:** Adiciona uma nova entrada de auditoria ao sistema.

#### Parâmetros de Entrada (JSON): 
- `auditoriaId` (long): ID da auditoria (gerado automaticamente).
- `usuario` (String): Nome do usuário que realizou a ação.
- `acao` (String): Descrição da ação realizada.
- `dataAcao` (String): Data da ação (formato: yyyy-MM-dd).

**Exemplo de Requisição:**

```bash
POST http://localhost:8080/api/o/auditoria/auditorias
```

**Corpo (JSON):**

```bash
{
  "usuario": "johndoe",
  "acao": "Acesso ao sistema",
  "dataAcao": "2024-10-21"
}
```

**Exemplo de Resposta (JSON):**

```bash
{
  "auditoriaId": 1,
  "usuario": "johndoe",
  "acao": "Acesso ao sistema",
  "dataAcao": "2024-10-21"
}
```

**Possíveis Respostas de Erro:**
* Código 400: Erro na validação da auditoria.
* Código 500: Erro interno ao adicionar a entrada de auditoria.

<br>

### 2 - Deletar uma Entrada de Auditoria pelo ID

- **Método:** DELETE
- **Rota:** `http://localhost:8080/api/o/auditoria/auditorias/{auditoriaId}`
- **Parâmetro de Caminho:** `auditoriaId` (long): ID da auditoria a ser deletada.
- **Descrição:** Remove uma entrada de auditoria existente no sistema.

**Exemplo de Requisição:**

```bash
DELETE http://localhost:8080/api/o/auditoria/auditorias/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "message": "Auditoria deletada com sucesso.",
  "auditoriaId": 1
}
```

**Possíveis Respostas de Erro:**
* Código 404: Auditoria não encontrada.
* Código 500: Erro interno ao deletar a entrada de auditoria.

<br>

### 3 - Recuperar uma Entrada de Auditoria pelo ID

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/auditoria/auditorias/{auditoriaId}`
- **Parâmetro de Caminho:** `auditoriaId` (long): ID da auditoria a ser buscada.
- **Descrição:** Retorna os dados de uma entrada de auditoria existente no sistema.

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/auditoria/auditorias/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "auditoriaId": 1,
  "usuario": "johndoe",
  "acao": "Acesso ao sistema",
  "dataAcao": "2024-10-21"
}
```

**Possíveis Respostas de Erro:**
* Código 404: Auditoria não encontrada.
* Código 500: Erro interno ao buscar a entrada de auditoria.

<br>

### 4 - Recuperar todas as Entradas de Auditoria

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/auditoria/auditorias`
- **Descrição:** Retorna uma lista com todas as entradas de auditoria cadastradas no sistema.

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/auditoria/auditorias
```

**Exemplo de Resposta (JSON):**

```bash
[
  {
    "auditoriaId": 1,
    "usuario": "johndoe",
    "acao": "Acesso ao sistema",
    "dataAcao": "2024-10-21"
  },
  {
    "auditoriaId": 2,
    "usuario": "janedoe",
    "acao": "Modificação de dados",
    "dataAcao": "2024-10-20"
  }
]
```

**Possíveis Respostas de Erro:**
* Código 500: Erro interno ao recuperar as entradas de auditoria.

<br>

### 5 - Contar o Total de Entradas de Auditoria

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/auditoria/auditorias/count`
- **Descrição:** Retorna o total de entradas de auditoria cadastradas no sistema

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/auditoria/auditorias/count
```

**Exemplo de Resposta (JSON):**

```bash
{
  "total": 2
}
```

**Possíveis Respostas de Erro:**
* Código 500: Erro interno ao contar as entradas de auditoria.

<br>

<br>
<br>
<br>

[Voltar para página do desafio](/Conteudo_rockets/Desafio3/Desafio3.md)
[Voltar para o inicio](/README.md)