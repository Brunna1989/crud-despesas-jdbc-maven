# CRUD - Despesas - JDBC

Este é um projeto simples de CRUD (Create, Read, Update, Delete) em Java utilizando JDBC (Java Database Connectivity) para interagir com um banco de dados PostgreSQL. O objetivo do programa é gerenciar despesas, permitindo a inserção, consulta, atualização e exclusão de registros.

## Tecnologias Utilizadas

- Java 11: Linguagem de programação utilizada no desenvolvimento.
- PostgreSQL 42.2.9: Banco de dados utilizado para armazenar as despesas.
- Maven: Gerenciador de dependências utilizado para configurar o projeto e suas dependências.

## Estrutura do Projeto

O projeto está dividido em pacotes, cada um responsável por uma camada:

- `com.br.brunnadornelles.model`: Contém as classes que representam o modelo de dados (Despesa e Categoria).
- `com.br.brunnadornelles.dao`: Define a interface IDespesaDAO e sua implementação DespesaDAO para operações de persistência.
- `com.br.brunnadornelles.infra`: Fornece a classe ConnectionFactory para obtenção de conexões com o banco de dados.
- `com.br.brunnadornelles`: Apresenta a classe Application com um exemplo de uso, inserindo uma despesa no banco de dados.

## Como Testar e Executar

### Configuração do Banco de Dados:

1. Certifique-se de ter o PostgreSQL instalado e crie um banco de dados chamado DespesasDB.
2. Ajuste as credenciais (username e password) na classe ConnectionFactory conforme necessário.

### Execução do Projeto:

1. Clone o repositório para o seu ambiente local.
2. Abra o projeto em sua IDE preferida.
3. Execute a classe Application para inserir uma despesa de exemplo no banco de dados.

### Verificação no Banco de Dados:

- Conecte-se ao banco de dados DespesasDB.
- Execute consultas SQL para verificar os registros na tabela Despesas.

## Observações

- Este projeto é um exemplo educativo e pode ser estendido para incluir mais funcionalidades, como atualização e exclusão de despesas.
- Certifique-se de ter o driver JDBC apropriado para o PostgreSQL em seu classpath.
- Este README fornece uma visão geral do projeto, suas tecnologias e instruções para executar e testar. Sinta-se à vontade para expandir e personalizar conforme necessário.
