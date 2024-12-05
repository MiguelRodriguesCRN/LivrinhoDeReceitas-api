# API de Livro de Receitas 🍳

## Alunos do Projeto:

Miguel Rodrigues Carneiro || 
Leonardo Santos De Lima



## **Descrição do Repositório:**

Bem-vindo ao repositório da **API de Livro de Receitas**, uma aplicação backend desenvolvida com **Spring Boot** e **Spring Data**. Esta API permite criar, gerenciar e compartilhar receitas culinárias de forma simples e eficiente. Ideal para projetos gastronômicos ou para quem deseja aprender a construir APIs RESTful com Spring.

## 🚀 Recursos Principais

- **Gerenciamento de Receitas:**  
  Crie, edite, visualize e exclua receitas, com informações detalhadas como título, descrição, tempo de preparo, ingredientes e etapas de preparo.
  
- **Gestão de Ingredientes:**  
  Adicione e gerencie os ingredientes necessários para cada receita.
  
- **Categorias de Receitas:**  
  Organize as receitas em categorias como "sobremesas", "pratos principais", "entradas", etc.
  
- **Busca de Receitas:**  
  Pesquise receitas por nome, ingredientes ou categoria, utilizando filtros otimizados.
  
- **Persistência de Dados:**  
  Armazenamento de receitas e ingredientes utilizando **Spring Data JPA** com bancos de dados relacionais (MySQL, PostgreSQL, etc).
  
- **Documentação Interativa:**  
  A API é documentada de forma interativa com **Swagger**, facilitando o uso e integração com outros sistemas.

---

## 🛠️ Tecnologias Utilizadas

- **Backend:**  
  [Spring Boot](https://spring.io/projects/spring-boot) para a construção da API RESTful.
  
- **Persistência de Dados:**  
  [Spring Data JPA](https://spring.io/projects/spring-data) para integração com banco de dados relacional.
  
- **Banco de Dados:**  
  Suporte a bancos de dados relacionais como **MySQL**, **PostgreSQL** ou **H2** (configurável no arquivo de propriedades).
  
- **Documentação da API:**  
  [Swagger](https://swagger.io/) para documentação automática e interação com a API.
  
---

## 📖 Como Usar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/api-livro-receitas.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd api-livro-receitas
   ```

3. **Configure o banco de dados:**  
   Edite o arquivo `application.properties` ou `application.yml` para configurar as variáveis de conexão com o banco de dados.

4. **Execute a aplicação:**
   - Usando o wrapper do Maven:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou com o Maven diretamente:
     ```bash
     mvn spring-boot:run
     ```
