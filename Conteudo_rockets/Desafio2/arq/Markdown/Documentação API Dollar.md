
# Documentação da API REST Dollar (Consulta de Taxa de Câmbio do Dólar)

## Descrição
Este módulo fornece uma API REST para consultar a taxa de câmbio do dólar americano (USD) em relação a outras moedas, utilizando o serviço da API currencylayer. A API permite obter a taxa de câmbio para uma moeda específica (Neste caso o real) e retorna os dados no formato JSON.

<br>

### URL base

```bash
http://localhost:8080/api/o/dollar-api
```

<br>

### Endpoints

#### 1. **Obter a taxa de câmbio do dólar em relação ao Real Brasileiro (BRL)**

- **Método:** `GET`
- **Rota:** `http://localhost:8080/api/o/dollar-api/dollarRate`
- **Descrição:** Retorna a taxa de câmbio do dólar (USD) para o Real Brasileiro (BRL).

**Exemplo de Requisição:**
```bash
GET /o/dollar-api/dollarRate
```
**Exemplo de Resposta (JSON):**

```json
{
  "USD_BRL": 5.27
}
```
<br>

#### 2. Obter a taxa de câmbio do dólar em relação a uma moeda específica
- **Método:** `GET`
- **Rota:** `http://localhost:8080/api/o/dollar-api/dollarRate/{currency}`
- **Parâmetro de Caminho:** currency: Código da moeda para a qual a taxa de câmbio será consultada. Deve ser passado no formato ISO 4217 (Ex.: BRL, EUR, JPY).
- **Descrição:** Retorna a taxa de câmbio do dólar (USD) para a moeda especificada.
  
**Exemplo de Requisição:**

```bash
GET http://localhost:8080/api/o/dollar-api/dollarRate/EUR
```

**Exemplo de Resposta (JSON):**

```json
{
  "USD_EUR": 0.85
}
```
<br>

#### Possíveis Respostas de Erro

* Código 500: Erro interno ao buscar a taxa de câmbio.

**Exemplo de Resposta de Erro (JSON):**

```json
{
  "error": "Error fetching exchange rate: Invalid currency code"
}
```
<br>
<br>

### Considerações
A API utiliza a chave de acesso currencylayer para consultar as taxas de câmbio.
A resposta JSON inclui a cotação da moeda solicitada em relação ao dólar.

<br>
<br>

[Voltar para a página do projeto](/Conteudo_rockets/Desafio2/GX2%20Rockets%20-%20Liferay%20Community%20Edition%20Portal%207.4.3.120%20CE%20GA120/README.md) <br>

[Voltar inicio](/README.md) <br>