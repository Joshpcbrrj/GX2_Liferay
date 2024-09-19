# Passos para criar a Api Tasks com persistencia dos dados no banco Mysql

## 1. Criar o Service Builder

- **Nome do Service Builder:** desafio_tasks
- **Nome do Pacote:** br.com.gx2

<details>
  <summary>Prints</summary>

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Criar_service-Builder1.jpg" alt="" width="800">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Criar_service-Builder2.jpg" alt="" width="800">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Criar_service-Builder3.jpg" alt="" width="800">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Criar_service-Builder4.jpg" alt="" width="800">
  
</details>

<br>

## 2. Modificar o arquivo `service.xml`

<details>
<summary>Código do arquivo service.xml</summary>

```xml
<!-- Define o driver JDBC utilizado para se conectar ao banco de dados MySQL -->
<property name="jdbc.default.driverClassName" value="com.mysql.cj.jdbc.Driver" />

<!-- Especifica a URL de conexão ao banco de dados MySQL, localizado no servidor local (localhost) -->
<!-- O banco de dados é "lportal", com os seguintes parâmetros adicionais: -->
<!-- - useUnicode=true: suporte a caracteres Unicode -->
<!-- - characterEncoding=UTF-8: define o conjunto de caracteres como UTF-8 -->
<!-- - useFastDateParsing=false: desativa otimização de parsing para datas -->
<property name="jdbc.default.url" value="jdbc:mysql://localhost:3306/lportal?useUnicode=true&amp;charsetEncoding=UTF-8&amp;useFastDateParsing=false" />

<!-- Nome de usuário para autenticação no banco de dados -->
<property name="jdbc.default.username" value="root" />

<!-- Senha para o nome de usuário especificado -->
<property name="jdbc.default.password" value="root" />

```
</details>

<br>


## 3. Executar buildService

- Ação: Gerar as classes de entidade com base na configuração do service.xml.

<details>
  <summary>Prints</summary>

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Exec_build-service1.jpg" alt="" width="900">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Exec_build-service2.jpg" alt="" width="800">
  
</details>

<br>

## 4 - Adicionar conexão do portal com o MySQL 

Abrir o arquivo: `bundles/portal-ext.properties`
  
<details>
<summary>Adicionar conexão com o bando usando o código abaixo:</summary>

```xml
<!-- Define o driver JDBC utilizado para se conectar ao banco de dados MySQL -->
<property name="jdbc.default.driverClassName" value="com.mysql.cj.jdbc.Driver" />

<!-- Especifica a URL de conexão ao banco de dados MySQL, localizado no servidor local (localhost) -->
<!-- O banco de dados é "lportal", com os seguintes parâmetros adicionais: -->
<!-- - useUnicode=true: suporte a caracteres Unicode -->
<!-- - characterEncoding=UTF-8: define o conjunto de caracteres como UTF-8 -->
<!-- - useFastDateParsing=false: desativa otimização de parsing para datas -->
<property name="jdbc.default.url" value="jdbc:mysql://localhost:3306/lportal?useUnicode=true&amp;charsetEncoding=UTF-8&amp;useFastDateParsing=false" />

<!-- Nome de usuário para autenticação no banco de dados -->
<property name="jdbc.default.username" value="root" />

<!-- Senha para o nome de usuário especificado -->
<property name="jdbc.default.password" value="root" />

```
</details>

<br>

## 5 -  Criar Conexão no MySQL (Banco de Dados `lportal`)

**Nome da Conexão:** lportal

<details>
  <summary>Prints</summary>

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Mysql1.jpg" alt="" width="900">
  
</details>

<br>

## 6 - Executar o Servidor do Liferay
**Objetivo:** Rodar o servidor do Liferay para que as tabelas do banco de dados sejam criadas automaticamente.

<br>

## 7 - Confirmar Criação da Tabela desafio_task no MySQL
**Verificação:** Confirmar que a tabela desafio_task foi criada no banco de dados lportal.

<details>
  <summary>Prints</summary>

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Mysql2.jpg" alt="" width="900">
  
</details>

<br>

## 8 - Implementar o CRUD personalizado na Classe `TaskLocalServiceImpl`
**Caminho da classe:** modules/desafio_tasks/desafio_tasks-service/src/main/java/br/com/gx2/service/imp

<details>
  <summary>Código da classe TaskLocalServiceImpl</summary>

  ```java
package br.com.gx2.service.impl;

import br.com.gx2.exception.NoSuchTaskException;
import br.com.gx2.model.Task;
import br.com.gx2.service.base.TaskLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * Implementação personalizada de CRUD para a entidade Task
 */
@Component(
    property = "model.class.name=br.com.gx2.model.Task",
    service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl implements AopService {

    // 1 - Método para criar uma nova tarefa
    public Task createTask(
            String title, String description, Date dueDate, boolean completed,
            ServiceContext serviceContext) throws PortalException {

        // Gera um novo ID para a tarefa usando o counterLocalService
        long taskId = counterLocalService.increment(Task.class.getName());

        // Cria uma nova instância de Task
        Task task = taskLocalService.createTask(taskId);

        // Define os valores fornecidos pelo usuário
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(completed);

        // Adiciona a nova tarefa ao banco de dados
        taskLocalService.addTask(task);

        return task; // Retorna a tarefa criada
    }

    // 2 - Método para apagar uma tarefa com base no ID fornecido
    public Task deleteTask(long taskId) throws PortalException {
        // Busca a tarefa pelo ID
        Task task = taskLocalService.getTask(taskId);

        // Verifica se a tarefa foi encontrada
        if (Validator.isNull(task)) {
            throw new NoSuchTaskException("Task with taskId " + taskId + " not found");
        }

        // Remove a tarefa do banco de dados
        return taskLocalService.deleteTask(task);
    }

    // 3 - Método para listar todas as tarefas
    public List<Task> getAllTasks() {
        // Retorna todas as tarefas, sem limite (-1, -1 para listar tudo)
        return taskLocalService.getTasks(-1, -1);
    }

    // 4 - Método para buscar uma tarefa pelo ID fornecido
    public Task getTaskById(long taskId) throws PortalException {
        // Busca e retorna a tarefa pelo ID
        return taskLocalService.getTask(taskId);
    }

    // 5 - Método para atualizar uma tarefa existente
    public Task updateTask(
            long taskId, String title, String description, Date dueDate,
            boolean completed, ServiceContext serviceContext) throws PortalException {

        // Busca a tarefa pelo ID
        Task task = taskLocalService.getTask(taskId);

        // Verifica se a tarefa foi encontrada
        if (Validator.isNull(task)) {
            throw new NoSuchTaskException("Task with taskId " + taskId + " not found");
        }

        // Atualiza os detalhes da tarefa com os valores fornecidos
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(completed);
        task.setModifiedDate(serviceContext.getModifiedDate(new Date())); // Atualiza a data de modificação

        // Atualiza a tarefa no banco de dados
        return taskLocalService.updateTask(task);
    }
}
```
  
</details>

<br>

## 9 - Criar modulo rest para expor os métodos do service-builder “desafio_taks”

- **Nome do módulo REST:** desafio_rest_tasks
- **Pacote:** br.com.gx2
- **Classe:** RestTasks

<details>
  <summary>Prints</summary>

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Rest1.jpg" alt="" width="1000">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Rest2.jpg" alt="" width="1000">

  <img src="/Conteudo_rockets/Desafio2/arq/Img/Rest3.jpg" alt="" width="1000">
  
</details>

<br>

## 10 - Importar o Módulo Service Builder e a dependencia do json no build.gradle do Módulo REST `desafio_rest_tasks`

* **Caminho do arquivo:** \modules\desafio_rest_tasks\build.gradle

<details>
  <summary>Código do arquivo build.gradle</summary>

```xml
dependencies {
	compileOnly group: "com.liferay.portal", name: "release.portal.api"
	compileOnly group: "org.osgi", name: "org.osgi.service.jaxrs"

	// Dependência do módulo Service Builder
	compileOnly project(':modules:desafio_tasks:desafio_tasks-service')

	// Dependência da biblioteca JSON
	implementation group: 'org.json', name: 'json', version: '20230227'
}
```
</details>

<br>

## 11 Implementar a Comunicação entre o Módulo Service Builder e o Módulo REST

* **Caminho da classe:** modules\desafio_rest_tasks\src\main\java\br\com\gx2\application\RestTasksApplication.java

<details>
  <summary>Código da classe RestTasksApplication</summary>

```jsx
package br.com.gx2.application;

import br.com.gx2.model.Task;
import br.com.gx2.service.TaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * API REST personalizada para a entidade Task
 */
@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/task-api",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=Task-api.Rest"
    },
    service = Application.class
)
public class RestTasksApplication extends Application {

    // Referência ao serviço TaskLocalService para manipulação de tarefas
    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public Set<Object> getSingletons() {
        // Retorna a instância atual como um singleton para a aplicação REST
        return Collections.singleton(this);
    }

    // Método de teste para verificar se a API está funcionando
    @GET
    @Produces("text/plain")
    public String working() {
        return "It works!";
    }

    // 1. Método REST para listar todas as tarefas
    @GET
    @Path("/tasks")
    @Produces("application/json")
    public List<Task> getAllTasks() {
        // Retorna a lista de todas as tarefas usando o serviço TaskLocalService
        return _taskLocalService.getAllTasks();
    }

    // 2. Método REST para obter uma tarefa por ID
    @GET
    @Path("/tasks/{taskId}")
    @Produces("application/json")
    public Task getTaskById(@PathParam("taskId") long taskId) throws PortalException {
        // Retorna a tarefa específica pelo ID usando o serviço TaskLocalService
        return _taskLocalService.getTaskById(taskId);
    }

    // 3. Método REST para criar uma nova tarefa
    @POST
    @Path("/tasks")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTask(String body) {
        try {
            // Converte o corpo da requisição JSON para um JSONObject
            JSONObject jsonObject = new JSONObject(body);

            // Extrai os dados do JSONObject
            String title = jsonObject.getString("title");
            String description = jsonObject.getString("description");
            String dueDateString = jsonObject.optString("dueDate", null); // Pode ser null se não estiver presente
            boolean isCompleted = jsonObject.optBoolean("isCompleted", false);

            // Converte a data se estiver presente
            Date dueDate = null;
            if (dueDateString != null && !dueDateString.isEmpty()) {
                dueDate = new Date(Long.parseLong(dueDateString));
            }

            // Cria um novo ServiceContext (não requer uma requisição específica)
            ServiceContext serviceContext = new ServiceContext();

            // Cria a nova tarefa usando o serviço TaskLocalService
            Task newTask = _taskLocalService.createTask(
                    title,
                    description,
                    dueDate,
                    isCompleted,
                    serviceContext
            );

            // Retorna a tarefa criada com status OK
            return Response.ok(newTask).build();
        } catch (PortalException e) {
            // Retorna erro interno do servidor se ocorrer uma exceção PortalException
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (Exception e) {
            // Retorna erro de solicitação ruim se ocorrer uma exceção ao processar o JSON
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao processar o JSON de entrada: " + e.getMessage()).build();
        }
    }

    // 4. Método REST para atualizar uma tarefa por ID
    @PUT
    @Path("/tasks/{taskId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateTask(
            @PathParam("taskId") long taskId, String body) {
        try {
            // Converte o corpo da requisição JSON para um JSONObject
            JSONObject jsonObject = new JSONObject(body);

            // Extrai os dados do JSONObject
            String title = jsonObject.getString("title");
            String description = jsonObject.getString("description");
            String dueDateString = jsonObject.optString("dueDate", null);
            boolean isCompleted = jsonObject.optBoolean("isCompleted", false);

            // Converte a data se estiver presente
            Date dueDate = null;
            if (dueDateString != null && !dueDateString.isEmpty()) {
                dueDate = new Date(Long.parseLong(dueDateString));
            }

            // Cria um novo ServiceContext (não requer uma requisição específica)
            ServiceContext serviceContext = new ServiceContext();

            // Atualiza a tarefa usando o serviço TaskLocalService
            Task updatedTask = _taskLocalService.updateTask(
                    taskId,
                    title,
                    description,
                    dueDate,
                    isCompleted,
                    serviceContext
            );

            // Retorna a tarefa atualizada com status OK
            return Response.ok(updatedTask).build();
        } catch (PortalException e) {
            // Retorna erro interno do servidor se ocorrer uma exceção PortalException
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (Exception e) {
            // Retorna erro de solicitação ruim se ocorrer uma exceção ao processar o JSON
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao processar o JSON de entrada: " + e.getMessage()).build();
        }
    }

    // 5. Método REST para apagar uma tarefa por ID
    @DELETE
    @Path("/tasks/{taskId}")
    @Produces("application/json")
    public Response deleteTask(@PathParam("taskId") long taskId) {
        try {
            // Remove a tarefa usando o serviço TaskLocalService e retorna a tarefa removida
            Task deletedTask = _taskLocalService.deleteTask(taskId);
            return Response.ok(deletedTask).build();
        } catch (PortalException e) {
            // Retorna erro de não encontrado se ocorrer uma exceção PortalException
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
```
</details>

<br>
<br>
<br>

[Voltar para a página do projeto](/Conteudo_rockets/Desafio2/GX2%20Rockets%20-%20Liferay%20Community%20Edition%20Portal%207.4.3.120%20CE%20GA120/README.md) <br>

[Voltar inicio](/README.md)