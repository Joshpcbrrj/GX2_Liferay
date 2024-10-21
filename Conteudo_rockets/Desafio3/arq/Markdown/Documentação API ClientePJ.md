# Documentação da API REST ClientePJ

## Descrição
Este módulo fornece uma API REST para gerenciar clientes corporativos do tipo Pessoa Jurídica (PJ). A API permite realizar operações como criar, atualizar, deletar e consultar clientes PJ, com os dados retornados no formato JSON.

---

### URL base

```bash
http://localhost:8080/api/o/cliente-pj-api
```
<br>

## Endpoints:

### 1 - Adicionar um novo cliente PJ

- **Método:** POST
- **Rota:** `http://localhost:8080/api/o/cliente-pj-api/clientes`
- **Descrição:** Adiciona um novo Cliente PJ (Pessoa Jurídica) ao sistema.

#### Parâmetros de Entrada (JSON):
- `razaoSocial` (String): Razão social da empresa.  
- `cnpj` (String): CNPJ da empresa.

**Exemplo de Requisição:**

```bash
POST http://localhost:8080/api/o/ccorp/ClientePj
```

**Corpo (JSON):**

```bash
{
  "razaoSocial": "Empresa XYZ",
  "cnpj": "12.345.678/0001-90"
}
```

**Exemplo de Resposta (JSON):**

```bash
{
  "clientePJId": 1,
  "razaoSocial": "Empresa ABC Ltda",
  "cnpj": "12.345.678/0001-99"
}
```

**Possíveis Respostas de Erro:**
* Código 500: Erro interno ao adicionar o cliente PJ.

<br>

### 2 - Deletar um Cliente PJ pelo ID

- **Método:** DELETE
- **Rota:** `http://localhost:8080/api/o/ccorp/ClientePj/{clientePJId}`
- **Parâmetro de Caminho:** `clientePJId` (long): ID do Cliente PJ a ser removido.
- **Descrição:** Remove o registro de um Cliente PJ do sistema.
  
**Exemplo de Requisição:**

```bash
DELETE http://localhost:8080/api/o/ccorp/ClientePj/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "clientePJId": 1,
  "razaoSocial": "Empresa ABC Ltda",
  "cnpj": "12.345.678/0001-99"
}
```

**Possíveis Respostas de Erro:**
* Código 404: Cliente PJ não encontrado.
* Código 500: Erro interno ao deletar o cliente PJ.


<br>

### 3 - Buscar um Cliente PJ pelo ID

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/ccorp/ClientePj/{clientePJId}`
- **Parâmetro de Caminho:** `clientePJId` (long): ID do Cliente PJ a ser buscado.
- **Descrição:** Retorna os dados de um Cliente PJ existente no sistema.
  
**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/ccorp/ClientePj/1
```

**Exemplo de Resposta (JSON):**

```bash
{
  "clientePJId": 1,
  "razaoSocial": "Empresa ABC Ltda",
  "cnpj": "12.345.678/0001-99"
}
```

**Possíveis Respostas de Erro:**
* Código 404: Cliente PJ não encontrado.
* Código 500: Erro interno ao buscar o cliente PJ.

<br>

### 4 - Buscar um Cliente PJ pelo CNPJ

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/ccorp/ClientePj/cnpj/{cnpj}`
- **Parâmetro de Caminho:** `cnpj` (String): CNPJ do Cliente PJ a ser buscado.
- **Descrição:** Retorna os dados de um Cliente PJ pelo seu CNPJ.
  
**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/ccorp/ClientePj/cnpj/12.345.678/0001-99
```

**Exemplo de Resposta (JSON):**

```bash
{
  "clientePJId": 1,
  "razaoSocial": "Empresa ABC Ltda",
  "cnpj": "12.345.678/0001-99"
}
```

**Possíveis Respostas de Erro:**
* Código 404: Cliente PJ não encontrado.
* Código 500: Erro interno ao buscar o cliente PJ.

<br>

### 5 - Recuperar todos os Clientes PJ

- **Método:** GET
- **Rota:** `http://localhost:8080/api/o/ccorp/ClientePj`
- **Descrição:** Retorna uma lista com todos os Clientes PJ cadastrados no sistema.
  
**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/ccorp/ClientePj
```

**Exemplo de Resposta (JSON):**

```bash
[
  {
    "clientePJId": 1,
    "razaoSocial": "Empresa ABC Ltda",
    "cnpj": "12.345.678/0001-99"
  },
  {
    "clientePJId": 2,
    "razaoSocial": "Empresa XYZ S.A.",
    "cnpj": "98.765.432/0001-10"
  }
]
```

**Possíveis Respostas de Erro:**
* Código 500: Erro interno ao recuperar os clientes PJ.

<br>

### 6 - Atualizar um Cliente PJ
- **Método:** `PUT`  
- **Rota:** `http://localhost:8080/api/o/ccorp/ClientePj/{clientePJId}`  
- **Parâmetro de Caminho:** `clientePJId` (long): ID do Cliente PJ a ser atualizado.  
- **Descrição:** Atualiza os dados de um Cliente PJ existente.

#### Parâmetros de Entrada (JSON):
- `razaoSocial` (String): Nova razão social da empresa.  
- `cnpj` (String): Novo CNPJ da empresa.

**Exemplo de Requisição:**

```bash
PUT http://localhost:8080/api/o/ccorp/ClientePj/1
```
**Corpo (JSON):**

```bash
{
  "razaoSocial": "Nova Razão Social Ltda",
  "cnpj": "98.765.432/0001-10"
}
```
**Exemplo de Resposta (JSON):**
```json
{
  "clientePJId": 1,
  "razaoSocial": "Nova Razão Social Ltda",
  "cnpj": "98.765.432/0001-10"
}
```
**Possíveis Respostas de Erro:**
* Código 404: Cliente PJ não encontrado.
* Código 500: Erro interno ao atualizar o cliente PJ.

<br>
<br>
<br>

[Voltar para página do desafio](/Conteudo_rockets/Desafio3/Desafio3.md)
[Voltar para o inicio](/README.md)

