# Desafio Lista de serviços

<details>
  <summary>Instruções do desafio</summary>
Para chegar à solução proposta de criação de um serviço local para registrar e listar tarefas no Liferay usando o Service Builder, é importante entender alguns conceitos e classes fundamentais. Aqui está uma lista das principais classes e conceitos que você precisará estudar:

1. **Service Builder**:
    - O Service Builder é uma ferramenta do Liferay que gera automaticamente código Java para criar e gerenciar entidades de dados e serviços relacionados.
    - Ele é configurado através de um arquivo XML chamado `service.xml`, onde você define suas entidades de dados e os serviços associados a elas.
    
    **Exemplo de arquivo `service.xml`**:
    
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.3.1//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_3_1.dtd">
    
    <service-builder package-path="com.example.tasks">
    
       <!-- Define a entidade de Tarefa -->
       <entity name="Task" table="Tasks" uuid="true">
          <column name="taskId" type="long" primary="true" />
          <column name="name" type="String" />
          <column name="description" type="String" />
       </entity>
    
    </service-builder>
    ```

<br>

2. **Model**:
    - No contexto do Service Builder, o "Model" refere-se às classes Java que representam suas entidades de dados.
    - Essas classes são geradas automaticamente pelo Service Builder com base no `service.xml`.
    
    **Exemplo de classe modelo (Task.java)**:
    
    ```java
    package com.example.tasks.model;
    
    public class Task {
    
       private long taskId;
       private String name;
       private String description;
    
       // Getters e Setters
    }
    ```

<br>

3. **Service**:
    - As classes de serviço são responsáveis por fornecer operações para manipular e interagir com os dados.
    - No exemplo, criamos um serviço local (`TaskLocalService`) para adicionar e obter tarefas.
    
    **Exemplo de classe de serviço (TaskLocalService.java)**:
    
    ```java
    package com.example.tasks.service;
    
    import com.example.tasks.model.Task;
    import java.util.ArrayList;
    import java.util.List;
    
    public class TaskLocalService {
    
       private static List<Task> tasks = new ArrayList<>();
    
       public Task addTask(String name, String description) {
          Task task = new Task();
          task.setName(name);
          task.setDescription(description);
          tasks.add(task);
          return task;
       }
    
       public List<Task> getTasks() {
          return tasks;
       }
    }
    ```
    
<br>

### Além dessas classes específicas do Service Builder, é importante ter um entendimento básico sobre:

- **APIs do Liferay**:
    - Para interagir com o ambiente do Liferay e entender como seus componentes se comunicam entre si.
- **Java Servlets e JSP**:
    - Para desenvolver a lógica de apresentação e interação com o usuário, como é feito no portlet.
- **Java Collections Framework**:
    - Para manipular coleções de dados, como a lista de tarefas em nosso exemplo.

</details>

<br>

## Código arquivo .xml:

 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.3.1//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_3_1.dtd">

<!-- Define o pacote para as classes geradas -->
<service-builder package-path="com.example.tasks">

    <!-- Define a entidade de Tarefa -->
    <entity name="Task" table="Tasks" uuid="true">
        <!-- Define os campos da entidade -->
        <column name="taskId" type="long" primary="true" />
        <column name="name" type="String" />
        <column name="description" type="String" />
    </entity>

</service-builder>
    
```

<br>

## Código arquivo service.java

```java
package com.example.tasks.service;

import com.example.tasks.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskLocalService {

    // Lista para armazenar as tarefas
    private static List<Task> tasks = new ArrayList<>();

    // Método para adicionar uma nova tarefa
    public Task addTask(String name, String description) {
        // Cria uma nova instância de Task
        Task task = new Task();
        // Define os atributos da tarefa
        task.setName(name);
        task.setDescription(description);
        // Adiciona a tarefa à lista de tarefas
        tasks.add(task);
        // Retorna a tarefa adicionada
        return task;
    }

    // Método para obter todas as tarefas
    public List<Task> getTasks() {
        // Retorna a lista de tarefas
        return tasks;
    }
}

```

<br>

## Código portlet.java

```java

package com.example.tasks.portlet;

import com.example.tasks.model.Task;
import com.example.tasks.service.TaskLocalService;

import java.util.List;

public class TaskPortlet {

    private TaskLocalService taskLocalService;

    // Construtor que recebe uma instância de TaskLocalService
    public TaskPortlet(TaskLocalService taskLocalService) {
        this.taskLocalService = taskLocalService;
    }

    // Método para adicionar uma nova tarefa
    public void addTask(String name, String description) {
        // Chama o método addTask() de TaskLocalService para adicionar a tarefa
        taskLocalService.addTask(name, description);
    }

    // Método para obter todas as tarefas
    public List<Task> getTasks() {
        // Chama o método getTasks() de TaskLocalService para obter as tarefas
        return taskLocalService.getTasks();
    }
}

```

<br>
<br>
<br>

[Voltar para a página do projeto](/Conteudo_rockets/Desafio1/Desafio1.md) <br>

[Voltar inicio](/README.md)