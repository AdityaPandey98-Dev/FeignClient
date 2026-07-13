# Spring Boot OpenFeign Client Example

A simple Spring Boot Microservices project demonstrating **inter-service communication using Spring Cloud OpenFeign**.

This project contains two microservices:

- **User Service** (Provider)
- **Product Service** (Consumer)

The Product Service fetches user information from the User Service using a **Feign Client** without writing manual HTTP client code.

---

## Architecture

```
                Client
                   │
                   ▼
        Product Service (8082)
                   │
            OpenFeign Client
                   │
         HTTP REST Request
                   │
                   ▼
          User Service (8081)
                   │
              Returns JSON
```

---

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Cloud OpenFeign
- Lombok
- Maven
- REST API

---

## Project Structure

```
FeignClient
│
├── user-service
│
└── product-service
```

### User Service

```
user-service
│
├── controller
├── service
├── model
├── resources
└── UserServiceApplication
```

### Product Service

```
product-service
│
├── controller
├── service
├── feign
├── dto
├── resources
└── ProductServiceApplication
```

---

## Features

- Spring Boot Microservices
- REST API Communication
- OpenFeign Client
- Constructor Injection
- Lombok
- Layered Architecture
- Clean Code Structure
- Externalized Configuration
- Simple API Testing

---

## Dependencies

### User Service

- Spring Web
- Lombok

### Product Service

- Spring Web
- Spring Cloud OpenFeign
- Lombok

---

## API Endpoints

### User Service

```
GET /users/{id}
```

Example

```
GET http://localhost:8081/users/1
```

Response

```json
{
  "id":1,
  "name":"Aditya"
}
```

---

### Product Service

```
GET /products/user/{id}
```

Example

```
GET http://localhost:8082/products/user/1
```

The Product Service internally calls

```
GET http://localhost:8081/users/1
```

using OpenFeign.

Response

```json
{
  "id":1,
  "name":"Aditya"
}
```

---

## How OpenFeign Works

```
Browser

↓

ProductController

↓

ProductService

↓

UserClient (Feign)

↓

HTTP Request

↓

User Service

↓

JSON Response

↓

Feign Decoder

↓

Java Object

↓

Return Response
```

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/<your-username>/FeignClient.git
```

---

### Start User Service

```
Port : 8081
```

Verify

```
GET http://localhost:8081/users/1
```

---

### Start Product Service

```
Port : 8082
```

Verify

```
GET http://localhost:8082/products/user/1
```

---

## Feign Client

```java
@FeignClient(
    name = "user-service",
    url = "${user-service.url}"
)
public interface UserClient {

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id);

}
```

---

## Configuration

application.yml

```yaml
server:
  port: 8082

user-service:
  url: http://localhost:8081
```

---

## Advantages of OpenFeign

- Less Boilerplate Code
- Declarative REST Client
- Easy Integration with Spring Boot
- Supports Load Balancing
- Supports Service Discovery
- Easy Error Handling
- Easy Logging
- Better Readability
- Easy Maintenance

---

## Future Enhancements

- Eureka Service Discovery
- Spring Cloud Gateway
- Resilience4j Circuit Breaker
- Retry Mechanism
- Fallback Support
- JWT Authentication
- Docker
- Kubernetes
- Distributed Tracing
- Config Server

---

## Learning Outcomes

After completing this project you will understand:

- Microservices Communication
- REST API Calls
- OpenFeign
- DTO Mapping
- Layered Architecture
- Constructor Injection
- Spring Boot Configuration
- Inter-Service Communication

---

## Author

**Aditya Pandey**


