#  Gerenciador de Usuários - Spring Boot + Docker + MySQL

Este é um projeto **Full Stack** completo que demonstra a integração de um backend robusto em Java com um banco de dados relacional persistente e uma interface web interativa.

##  Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA.
* **Banco de Dados:** MySQL 8.0 rodando via **Docker Container**.
* **Frontend:** HTML5, CSS3 (Bootstrap 5) e JavaScript (Fetch API).
* **Ferramentas:** Maven, IntelliJ IDEA, Git.

##  Funcionalidades

* **Create:** Cadastro de usuários via formulário web.
* **Read:** Listagem automática de usuários vindos do MySQL.
* **Delete:** Remoção de registros com confirmação.
* **Persistência:** Os dados não são perdidos ao reiniciar o servidor, graças ao volume do Docker.

##  Como Rodar o Projeto

1.  **Subir o Banco de Dados (Docker):**
    ```bash
    docker compose up -d
    ```
2.  **Executar a Aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
3.  **Acessar no Navegador:**
    Abra `http://localhost:8080`

##  Estrutura de Pastas Principal

* `src/main/java`: Lógica do Backend (Controller, Entity, Repository).
* `src/main/resources/static`: Interface Frontend (index.html).
* `docker-compose.yml`: Configuração da infraestrutura do banco.