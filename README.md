# 🛍️ Catálogo de Produtos e Simulação de Pedidos - Microsserviços com Spring Boot

Este projeto é uma aplicação Java baseada em microsserviços, desenvolvida com **Spring Boot** e **Spring Cloud**, que simula um sistema de **catálogo de produtos** e **gerenciamento de pedidos**. A comunicação entre os serviços é feita via HTTP, utilizando um **API Gateway** e **Service Discovery (Eureka)**.

## 📌 Funcionalidades

- ✅ Listar produtos disponíveis
- ✅ Consultar detalhes de um produto
- ✅ Criar pedidos a partir de IDs de produtos
- ✅ Calcular valor total do pedido
- ✅ Comunicação entre microsserviços com Spring Cloud Eureka
- ✅ Roteamento centralizado com API Gateway

---

## 🧱 Arquitetura

A arquitetura segue o padrão de microsserviços:

```
+-----------------+        +---------------------+        +----------------+
|  API Gateway    | <----> |   Produto Service   |        | Pedido Service |
+-----------------+        +---------------------+        +----------------+
         |
         v
 +----------------+
 | Eureka Server  |
 +----------------+
```

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- REST API (HTTP)
- Maven
- Lombok

---

## 🧪 Como Executar o Projeto

### 1. Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/catalogo-pedidos-microsservicos.git
cd catalogo-pedidos-microsservicos
```

### 2. Subir os Microsserviços

> Certifique-se de que as portas **8761**, **8080**, **8081** e **8082** estão livres.

Ordem recomendada:

```bash
# Terminal 1 - Subir o Eureka Server
cd eureka-server
./mvnw spring-boot:run

# Terminal 2 - Subir o Produto Service
cd produto-service
./mvnw spring-boot:run

# Terminal 3 - Subir o Pedido Service
cd pedido-service
./mvnw spring-boot:run

# Terminal 4 - Subir o API Gateway
cd api-gateway
./mvnw spring-boot:run
```

---

## 🌐 Endpoints

| Serviço           | Descrição                         | Endpoint                                |
|-------------------|-----------------------------------|-----------------------------------------|
| Produto Service   | Listar todos os produtos          | `GET /produtos`                         |
| Produto Service   | Obter detalhes de um produto      | `GET /produtos/{id}`                    |
| Pedido Service    | Criar pedido a partir de produtos | `POST /pedidos` (body: lista de IDs)   |

Todos os endpoints devem ser acessados via Gateway:  
Exemplo: `http://localhost:8080/produtos`

---

## 📦 Exemplo de Requisição de Pedido

```http
POST /pedidos
Content-Type: application/json

[1, 2]
```

**Resposta:**
```json
{
  "id": 1722623762000,
  "produtos": [1, 2],
  "total": 200.0
}
```

## 🧑‍💻 Autor
Otávio Guedes – Estudante de Engenharia de Software 🧠 💻 Foco em Back-end com Python e Java
