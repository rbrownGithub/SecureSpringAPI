# Secure Spring Boot API

This project demonstrates a secure Spring Boot API implementation with JWT authentication and role-based access control.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Running the Application

1. Clone the repository:
   ```
   git clone https://github.com/your-username/secure-spring-api.git
   ```

2. Navigate to the project directory:
   ```
   cd secure-spring-api
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

The application will start running at `http://localhost:8080`.

## Testing the APIs

You can use Postman or any other API testing tool to test the endpoints.

### Register a User

- **URL**: `POST http://localhost:8080/api/register`
- **Body**:
  ```json
  {
    "username": "testuser",
    "password": "password123",
    "roles": ["USER"]
  }
  ```

### Authenticate and Get Token

- **URL**: `POST http://localhost:8080/api/authenticate`
- **Body**:
  ```json
  {
    "username": "testuser",
    "password": "password123"
  }
  ```

### Access Protected Endpoints

Use the token received from the authentication endpoint in the `Authorization` header:

- **Header**: `Authorization: Bearer <your_token_here>`
- **USER Role Endpoint**: `GET http://localhost:8080/api/user`
- **ADMIN Role Endpoint**: `GET http://localhost:8080/api/admin`
- **Public Endpoint**: `GET http://localhost:8080/api/public`

## Security Features

- JWT-based authentication
- Role-based access control
- Method-level security using `@PreAuthorize` annotations

## Additional Notes

- The token expiration time can be configured in `application.properties`
- Make sure to keep the JWT secret key secure and consider using environment variables for sensitive information in a production environment