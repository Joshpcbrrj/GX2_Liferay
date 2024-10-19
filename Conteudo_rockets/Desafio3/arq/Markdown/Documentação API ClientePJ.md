# Documentação da API REST ClientePJ

## Descrição
Este módulo fornece uma API REST para gerenciar clientes corporativos do tipo Pessoa Jurídica (PJ). A API permite realizar operações como criar, atualizar, deletar e consultar clientes PJ, com os dados retornados no formato JSON.

---

### URL base

```bash
http://localhost:8080/api/o/cliente-pj-api
```
<br>

## Endpoints

### 1 - Adicionar um novo cliente PJ

- **Método:** POST
- **Rota:** `http://localhost:8080/api/o/cliente-pj-api/clientes`
- **Descrição:** Adiciona um novo Cliente PJ (Pessoa Jurídica) ao sistema.

#### Parâmetros de Entrada (JSON):
- `razaoSocial` (String): Razão social da empresa.  
- `cnpj` (String): CNPJ da empresa.  |

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
- **Descrição:** Remove o registro de um Cliente PJ do sistema. |
  
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