# Minha Primeira API com Spring Boot, Docker e MySQL

Este projeto é o marco inicial da minha jornada como desenvolvedor Backend Java. Ele consiste em uma API REST capaz de se comunicar com um banco de dados relacional rodando em um ambiente conteinerizado.

## Tecnologias Utilizadas

* **Java 17+** (Linguagem base)
* **Spring Boot 4.0.4** (Framework para agilizar o desenvolvimento)
* **Maven** (Gerenciador de dependências e build)
* **Docker & Docker Compose** (Infraestrutura do banco de dados)
* **MySQL 8.0** (Banco de dados relacional)
* **Spring Data JPA** (Persistência de dados)

## Arquitetura e Componentes

### 1. Camada de Controle (`RestController`)
Implementei o `HelloController.java` utilizando a biblioteca `org.springframework.web`. Ele expõe o endpoint `/hello` que valida se o servidor está respondendo corretamente às requisições HTTP.

### 2. Infraestrutura (Docker)
O arquivo `docker-compose.yml` isola o banco de dados. Configurei o mapeamento da **porta 3307** para evitar conflitos com instalações locais de MySQL, garantindo que a aplicação seja portável.

### 3. Persistência e Conexão
No arquivo `application.properties`, configurei o driver `com.mysql.cj.jdbc.Driver` e a estratégia `update` do Hibernate, permitindo que o Spring crie tabelas automaticamente no banco conforme o código evolui.

## Como Executar o Projeto

1.  **Subir o banco de dados:**
    ```bash
    docker-compose up -d
    ```
2.  **Rodar a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
3.  **Acessar no navegador:**
    `http://localhost:8080/hello`

---
 *Projeto desenvolvido com foco em aprender a integração entre Java, Docker e Banco de Dados.*
