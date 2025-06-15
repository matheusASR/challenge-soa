# Sistema de Recomendação de Investimentos

Este projeto contém:

- Microserviço RESTful com Spring Boot 3 e Java 17
- Serviço SOAP com contrato WSDL
- Integração simulada com WSO2 ESB
- JWT Authentication
- Banco H2
- Documentação Swagger
- Testes de carga com JMeter

---

## 🚀 Como rodar o microserviço REST

1. Importe o projeto `microservice-api` em sua IDE (IntelliJ)
2. Execute a classe principal com Spring Boot
3. Acesse:
   - Swagger: `http://localhost:8080/swagger-ui.html`
   - H2 Console: `http://localhost:8080/h2-console`

---

## 🔐 Endpoints de autenticação

- `POST /api/v1/auth/register`  
  Corpo JSON:
  ```json
  {
    "username": "admin",
    "password": "123"
  }
  ```

- `POST /api/v1/auth/login`  
  Corpo JSON:
  ```json
  {
    "username": "admin",
    "password": "123"
  }
  ```
  Retorna um token JWT.

---

## 📊 Testando com Postman

1. Faça `POST /api/v1/auth/login`
2. Copie o token e envie nas requisições protegidas com o header:

```
Authorization: Bearer <TOKEN>
```

3. Acesse `GET /api/v1/recommendations/{profile}` com os perfis:  
   - `conservative`  
   - `moderate`  
   - `aggressive`

---

## 🔁 WSO2 ESB - Fluxo simulado

Arquivo XML do fluxo: `esb-flows/investment-flow.xml`  
- Entrada: Requisição SOAP (por perfil)
- Encaminha para REST API e retorna resposta

---

## 📈 Testes com JMeter

Arquivo: `jmeter-tests/investments_test.jmx`

1. Abra com Apache JMeter
2. Execute o teste
3. Relatório gerado: `jmeter-tests/report.html`

