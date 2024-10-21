
# Desafio 3 Rockets GX2

<br>

>### Liferay Community Edition Portal 7.3 U.35

<img src="/Conteudo_rockets/Desafio3/arq/Img/1.png" alt="" width="500">

<br>
<br>

## Instruções do desafio:

[Documento do desafio](/Conteudo_rockets/Desafio3/arq/PDF/Desafio%20Técnico%20de%20Backend%20III%20.pdf) <br>


<details>
  <summary>Instruções do desafio</summary>

  # **Desafio Técnico 1: Implementação de Backend para Gerenciamento de Solicitações de Serviço**

  ### **Contexto:**

  A **Unimed** deseja implementar um sistema para gerenciar as solicitações de serviços feitas por seus clientes corporativos (pessoas jurídicas). Cada cliente pode fazer múltiplas solicitações e acompanhar o status delas. O objetivo é criar um backend que atenda às seguintes necessidades:

  ### **Requisitos Funcionais:**

  1. **Cadastro de Clientes Corporativos**:
      - O sistema deve permitir o cadastro de clientes com informações como: Razão Social, CNPJ.
  2. **Registro de Solicitações**:
      - Um cliente deve poder registrar solicitações de serviços. Cada solicitação deve conter os seguintes dados:
          - Código Unimed (identificador da unidade que está atendendo)
          - Descrição do serviço solicitado
          - Data da solicitação
          - Status da solicitação (pendente, em andamento, concluída)
          - Prioridade (baixa, média, alta)
  3. **Consulta de Solicitações**:
      - Os clientes devem poder consultar as suas solicitações de serviço, com filtros por status e data de criação.
      - A consulta deve retornar uma lista paginada de solicitações, mostrando os dados essenciais (código, descrição, data, status).
  4. **Atualização de Status**:
      - O sistema deve permitir que o status de uma solicitação seja atualizado (p.ex. de "pendente" para "concluída").
  5. **Auditoria**:
      - Todas as operações (criação, atualização) devem ser auditadas, armazenando a data e quem realizou a ação (cliente ou sistema interno).

</details>

<br>

## Setups:

[Como buildar o portal liferay em qualquer versão](/Conteudo_rockets/Desafio2/arq/Markdown/Como%20buildar%20o%20portal%20Liferay%20em%20qualquer%20versao.md) <br>

<br>

### Modulos de solução do desafio

[Módulos do desafio](/Conteudo_rockets/Desafio3/modules/)

>Importar na pasta "module" do seu portal Liferay

<br>

### Documentação das APIs:


[Documentação API ClientePJ](/Conteudo_rockets/Desafio3/arq/Markdown/Documentação%20API%20ClientePJ.md) <br>

[Documentação API Solicitação de serviço](/Conteudo_rockets/Desafio3/arq/Markdown/Documentação%20API%20SolicitacaoServico.md) <br>

[Documentação API Auditoria de acessos](/Conteudo_rockets/Desafio3/arq/Markdown/Documentação%20API%20Auditoria.md)<br>

<br>
<br>
<br>

[Voltar ao inicio](/README.md)