
# Desafio 2 Rockets GX2

## Requisitos:

[Documento do desafio](/Conteudo_rockets/Desafio2/arq/PDF/Desafio%20Rockets%20II.pdf) <br>


<details>
  <summary>Instruções do desafio</summary>
  
  # Desafios Técnicos Rocket II - Rocket Talents

## Trilha Liferay

### Instruções Gerais:

- O desafio será aberto ao final da call do dia **20/08/2024** e a entrega será no dia **16/09/2024**, até **23h59**.
- Durante esse período, dúvidas pontuais podem ser tiradas via Chat da Google no grupo com os padrinhos.
- O desafio consiste em:
    1. Realizar os exercícios, registrar no GitHub e enviar o link para avaliação.
    2. Apresentar o que foi feito para o Comitê de Padrinhos (Data a Marcar).
- A apresentação deve abranger todos os tópicos requeridos.
- **Importante**: O cumprimento do prazo (16/09/2024) faz parte da avaliação, e eventuais intercorrências devem ser avisadas com antecedência.

### Instruções do Desafio:

- Envie o link do Git contendo os tópicos solicitados e apresente em reunião com duração máxima de **15 minutos**.
- Certifique-se de demonstrar e explicar os conceitos de forma clara e concisa.
- A avaliação será baseada na:
    - Qualidade dos códigos.
    - Clareza da explicação.
    - Precisão das informações.
    - Demonstração prática dos conceitos.

### Preparação para a Apresentação:

- Certifique-se de ter uma boa conexão de internet, câmera e iluminação adequada.
- Esta avaliação testará seu **conhecimento prático** do Liferay, **qualidade de código** e **habilidade de comunicação**.

---

## Front-end:

### Desafio: Intranet

### Objetivo:

Criar um **dashboard personalizado** que mostre informações relevantes para os usuários.



### 1 - Dashboard Personalizado

**Objetivo**: Criar um dashboard personalizável com diferentes tipos de layouts, onde os usuários possam inserir componentes desejados através de uma interface de "Drag and Drop".

**Detalhes**:

- **Tipos de Layout**: 4 tipos de Grid Layout, onde os componentes podem ser arranjados em linhas e colunas.
- **Drag and Drop**: Permitir que os usuários possam adicionar, mover e remover componentes.
- **Componentes Adaptáveis**: Implementar estilos coerentes com o layout escolhido e opção de "collapse" dos componentes.
- **Estilização**: Utilizar **CSS**, **SASS** e **Bootstrap 4**. Implementar temas (claro/escuro) para melhorar a experiência do usuário.

### 2 - Componente Tarefas Pendentes

**Objetivo**: Criar uma seção de tarefas pendentes integrada com o backend para exibir e gerenciar tarefas.

**Detalhes**:

- **Visual**:
    - Lista de tarefas com diferentes estados: pendente, em progresso, concluída.
    - Filtros por status, data de vencimento, prioridade, etc.
    - Marcar tarefas como concluídas ou editar detalhes.
    - Design responsivo e intuitivo (Bootstrap/Material UI).
- **Integração com o Backend**:
    - Utilizar a API do backend para obter, criar, atualizar e deletar tarefas.
    - Assegurar que as tarefas exibidas pertençam ao usuário logado.
    - Manter sincronização entre frontend e backend.
- **Estilização**: Utilizar **CSS**, **SASS**, **Bootstrap 4** para estilizar os componentes.

### 3 - Componente Dados de Cotação

**Objetivo**: Criar um componente estilizado que exiba dados de uma **API de cotação** integrada com o backend.

**Detalhes**:

- **Obtenção de Dados**: Realizar requisições a uma API de cotação (ex.: API de câmbio da Open Exchange Rates) para obter dados em tempo real.
- **Tratamento de Erros**: Implementar tratamento de falhas nas requisições.
- **Visualização dos Dados**: Exibir dados de forma clara, utilizando gráficos e tabelas.
- **Estilização**: Utilizar **CSS**, **SASS**, **Bootstrap 4**.

---

## Back-end:

### 1 - Integração com API de Cotação de Dólar

**Passo a Passo**:

1. **Escolher a API de Cotação de Dólar**:
    - Exemplos: Open Exchange Rates, CurrencyLayer, Alpha Vantage.
2. **Obter as Credenciais da API**:
    - Criar uma conta e obter a **API key**.
3. **Criar um Módulo no Liferay**:
    - No terminal, vá até o diretório do workspace e crie um novo módulo:
        
        ```bash
        blade create -t mvc-portlet -p com.example.currencyconverter -c CurrencyConverterPortlet currency-converter
        ```
        
4. **Configurar Dependências**:
    - Adicione ao arquivo `build.gradle`:
        
        ```xml
        dependencies {
            compileOnly group: "org.apache.httpcomponents", name: "httpclient", version: "4.5.13"
        }
        ```
        
5. **Fazer a Chamada à API**:
    - Criar a classe `CurrencyConverterPortlet.java` e desenvolver o código para fazer a requisição GET à API.
6. **Exibir a Cotação no JSP**:
    - No arquivo `view.jsp`, exiba a cotação do dólar.

---

### 2 - Desenvolver um CRUD de Tarefas Pendentes com Service Builder

**Passo a Passo**:

1. **Criar o Módulo de Serviço**:
    
    ```bash
    blade create -t service-builder -p com.example.task -c Task task-service
    ```
    
2. **Definir o Modelo no `service.xml`**:
    - Modifique o arquivo `service.xml`:
        
        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.4.0//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_4_0.dtd">
        <service-builder package-path="com.example.task">
            <namespace>Task</namespace>
            <entity name="Task" local-service="true" remote-service="false">
                <column name="taskId" type="long" primary="true" />
                <column name="title" type="String" />
                <column name="description" type="String" />
                <column name="dueDate" type="Date" />
                <column name="completed" type="boolean" />
                <order by="dueDate ASC" />
            </entity>
        </service-builder>
        ```
        
3. **Gerar o Código com o Service Builder**:
    
    ```bash
    ./gradlew buildService
    ```
    
4. **Implementar o Portlet MVC**:
    - Criar o portlet:
        
        ```bash
        blade create -t mvc-portlet -p com.example.task -c TaskPortlet task-web
        ```
        
    - Configurar dependências no `build.gradle`:
        
        ```xml
        dependencies {
            compileOnly project(":modules:task-service")
        }
        ```
        
    - Implementar a lógica no arquivo `TaskPortlet.java`.
5. **Criar a Interface JSP**:
    - No arquivo `view.jsp`, exiba as tarefas e crie um formulário para novas tarefas.
6. **Empacotar e Implantar**:
    
    ```bash
    ./gradlew build
    ```
    

### Resumo:

1. Defina a entidade Task com o **Service Builder**.
2. Gere o código de serviços.
3. Implemente um **Portlet MVC** para gerenciar as tarefas.
4. Crie a interface **JSP** para permitir a criação e listagem de tarefas.
5. **Empacote** e teste os módulos no Liferay.



</details>

<details>
  <summary>Resumo do desafio de back-end</summary>

   ### 1. Integração com API de Cotação de Dólar
   O objetivo deste desafio é criar uma integração no Liferay que consuma uma API externa de cotação de dólar e exiba a informação em uma interface JSP. A abordagem envolve:

   * Escolher uma API de cotação (ex: CurrencyLayer).
   * Obter as credenciais (chave de API) da API escolhida.
   * Criar um módulo no Liferay (um portlet MVC) para gerenciar a integração.
   * Configurar dependências no projeto para permitir chamadas HTTP.
   * Implementar a chamada à API dentro de um portlet, e exibir a cotação do dólar em uma página JSP.

  <br>

   ### 2. Desenvolver um CRUD de Tarefas Pendentes com Service Builder
   O objetivo deste desafio é desenvolver um sistema de gerenciamento de tarefas no Liferay usando o Service Builder, que permite a criação e manipulação de entidades persistentes. A abordagem envolve:

   * Criar um módulo de serviço no Liferay para definir a entidade Task (Tarefa).
   * Definir o modelo da entidade no arquivo service.xml, especificando seus atributos (ex: título, descrição, data de * vencimento).
   * Gerar automaticamente o código de persistência e serviços usando o Service Builder.
   * Criar um portlet MVC para gerenciar as tarefas (inclusão, listagem, e edição).
   * Desenvolver a interface em JSP para permitir a interação com as tarefas e exibir a lista de tarefas pendentes.
   * Empacotar e implantar os módulos no Liferay para testar o sistema.

</details>

<br>
<br>

<br>

### Repositório do projeto

[Repositório com resolução do desafio](./GX2%20Rockets%20-%20Liferay%20Community%20Edition%20Portal%207.4.3.120%20CE%20GA120/)
