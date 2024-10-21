# Documentação da API REST Task (Gerenciamento de Tarefas com persistencia das tarefas no banco de dados)

---

## Descrição

Este módulo fornece uma API REST para gerenciar tarefas, permitindo criar, listar, atualizar e excluir tarefas. Os dados das tarefas são retornados no formato JSON, e incluem informações como título, descrição, data de vencimento e status de conclusão.

### Base URL

```bash
http://localhost:8080/o/task-api
```
<br>

### Endpoints

#### 1. **Listar todas as tarefas**

- **Método:** `GET`
- **Rota:** `http://localhost:8080/o/task-api/tasks`
- **Descrição:** Retorna uma lista de todas as tarefas cadastradas.

**Exemplo de Requisição:**
```bash
GET http://localhost:8080/o/task-api/tasks
```
**Exemplo de Resposta (JSON):**

```json
[
  {
    "taskId": 1,
    "title": "Task 1",
    "description": "This is task 1",
    "dueDate": "2024-09-20",
    "completed": false
  },
  {
    "taskId": 2,
    "title": "Task 2",
    "description": "This is task 2",
    "dueDate": "2024-09-25",
    "completed": true
  }
]
```
<br>

#### 2. **Obter uma tarefa por ID**

- **Método:** `GET`
- **Rota:** `http://localhost:8080/o/task-api/tasks/{taskId}`
- **Parâmetro de Caminho: taskId:** O ID da tarefa que será retornada.
- **Descrição:** Retorna uma tarefa específica com base no ID fornecido.

**Exemplo de Requisição:**

```bash
GET http://localhost:8080/o/task-api/tasks/1
```
**Exemplo de Resposta (JSON):**

```json
{
  "taskId": 1,
  "title": "Task 1",
  "description": "This is task 1",
  "dueDate": "2024-09-20",
  "completed": false
}

```
<br>

#### 3. **Criar uma nova tarefa**

- **Método:** `POST`
- **Rota:** `http://localhost:8080/o/task-api/tasks`
- **Descrição:** Cria uma nova tarefa.

**Exemplo de Requisição:**

```bash
POST http://localhost:8080/o/task-api/tasks
```
**Body (JSON):**

```json
{
  "title": "New Task",
  "description": "Task description",
  "dueDate": 1727025600000,
  "isCompleted": false
}
```

**Exemplo de Resposta (JSON):**

```json
{
  "taskId": 3,
  "title": "New Task",
  "description": "Task description",
  "dueDate": "2024-09-22",
  "completed": false
}
```
<br>

#### 4. **Atualizar uma tarefa existente**

- **Método:** `PUT`
- **Rota:** `http://localhost:8080/o/task-api/tasks/{taskId}`
- **Parâmetro de Caminho: taskId:** O ID da tarefa que será atualizada.
- **Descrição:** Atualiza os dados de uma tarefa com base no ID fornecido.

**Exemplo de Requisição:**

```bash
PUT /o/task-api/tasks/1
```

**Body (JSON):**

```json
{
  "title": "Updated Task",
  "description": "Updated description",
  "dueDate": 1727025600000,
  "isCompleted": true
}
```


**Exemplo de Resposta (JSON):**

```json
 {
  "taskId": 1,
  "title": "Updated Task",
  "description": "Updated description",
  "dueDate": "2024-09-22",
  "completed": true
}
```
<br>

#### 5. **Excluir uma tarefa**

- **Método:** `DELETE`
- **Rota:** `http://localhost:8080/o/task-api/tasks/{taskId}`
- **Parâmetro de Caminho: taskId:** O ID da tarefa a ser excluída.
- **Descrição:** Remove uma tarefa específica com base no ID fornecido.

**Exemplo de Requisição:**

```bash
DELETE /o/task-api/tasks/1
```

**Exemplo de Resposta (JSON):**

```json
{
  "message": "Task with ID 1 has been successfully deleted."
}
```

#### Possíveis Respostas de Erro
- 404 Not Found: Tarefa não encontrada.
- 500 Internal Server Error: Ocorreu um erro ao processar a solicitação.

**Exemplo de Resposta de Erro (JSON):**

```json
{
  "error": "Task with ID 1 not found"
}
```

<br>
<br>

### Considerações
- O campo `dueDate` deve ser fornecido como um timestamp em milissegundos desde 01/01/1970.
  
- Todas as requisições e respostas devem incluir o cabeçalho `Content-Type: application/json`.

<br>
<br>
<br>

[Voltar para a página do projeto](/Conteudo_rockets/Desafio2/Desafio2.md) <br>

[Voltar inicio](/README.md)