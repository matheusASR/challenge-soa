# Documentação Swagger - API de Recomendação de Investimentos

## 🔗 URL do Swagger UI
- http://localhost:8080/swagger-ui.html
- Documentação gerada automaticamente com SpringDoc OpenAPI 3

---

## 📂 Autenticação

### POST `/api/v1/auth/register`
- **Descrição**: Registra um novo usuário
- **Request Body**:
```json
{
  "username": "usuario1",
  "password": "senha123"
}
```
- **Response**: `200 OK` - "Usuário registrado com sucesso"

---

### POST `/api/v1/auth/login`
- **Descrição**: Realiza login e retorna um token JWT
- **Request Body**:
```json
{
  "username": "usuario1",
  "password": "senha123"
}
```
- **Response**: `200 OK` - Token JWT como `String`

---

## 📂 Recomendações

### GET `/api/v1/recommendations/{profile}`
- **Descrição**: Retorna recomendação de investimentos com base no perfil do usuário
- **Path Parameters**:
  - `profile`: `conservative`, `moderate`, `aggressive`
- **Headers**:
  - `Authorization: Bearer <token>`
- **Response**: `200 OK`
```text
Tesouro Direto e CDBs
```

---

## 🔐 Admin (somente para ROLE_ADMIN)

### GET `/api/v1/admin/only`
- **Descrição**: Endpoint exclusivo para usuários com papel de ADMIN
- **Headers**:
  - `Authorization: Bearer <token>`
- **Response**: `200 OK`
```text
Acesso restrito para administradores.
```

---

## 🔒 Autenticação JWT

- Use o endpoint `/auth/login` para obter o token.
- Envie o token em todas as requisições protegidas via header:
```
Authorization: Bearer <seu_token_aqui>
```

---

## 📌 Notas Técnicas

- API RESTful construída com Spring Boot 3 e Java 17
- Banco de dados H2 em memória
- Documentação automatizada com `springdoc-openapi-ui`
