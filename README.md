# Yasmine's Clean Microservices Project

A production-ready microservices architecture built with Spring Boot 3.2.0, Spring Cloud, and Java 21.

## Project Structure

\`\`\`
microservices-project/
├── discovery-service/       # Eureka Service Registry (Port 8761)
├── gateway-service/         # API Gateway (Port 8080)
├── billing-service/         # Billing Operations (Port 8081)
├── customer-service/        # Customer Management (Port 8082)
├── inventory-service/       # Product Inventory (Port 8083)
└── pom.xml                  # Parent POM with dependency management
\`\`\`

## Services Overview

### Discovery Service (Eureka Server)
- Service registry for service discovery
- Port: 8761
- URL: http://localhost:8761

### Gateway Service (API Gateway)
- Routes requests to appropriate microservices
- Port: 8080
- Routes:
  - `/api/billing/**` → billing-service
  - `/api/customers/**` → customer-service
  - `/api/inventory/**` → inventory-service

### Billing Service
- Manages bills and invoices
- Port: 8081
- Database: H2 (in-memory)
- Endpoints: `/api/billing/*`

### Customer Service
- Manages customer information
- Port: 8082
- Database: H2 (in-memory)
- Endpoints: `/api/customers/*`

### Inventory Service
- Manages product inventory and stock
- Port: 8083
- Database: H2 (in-memory)
- Endpoints: `/api/inventory/*`

## Running the Project

### Prerequisites
- Java 21+
- Maven 3.8+

### Start Services
1. **Discovery Service** (start first)
   \`\`\`bash
   cd discovery-service
   mvn spring-boot:run
   \`\`\`

2. **Gateway Service**
   \`\`\`bash
   cd gateway-service
   mvn spring-boot:run
   \`\`\`

3. **Billing Service**
   \`\`\`bash
   cd billing-service
   mvn spring-boot:run
   \`\`\`

4. **Customer Service**
   \`\`\`bash
   cd customer-service
   mvn spring-boot:run
   \`\`\`

5. **Inventory Service**
   \`\`\`bash
   cd inventory-service
   mvn spring-boot:run
   \`\`\`

## API Examples

### Create a Customer
\`\`\`bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Yasmine",
    "lastName": "Developer",
    "email": "yasmine@example.com",
    "phone": "1234567890",
    "address": "123 Tech Street"
  }'
\`\`\`

### Create a Product
\`\`\`bash
curl -X POST http://localhost:8080/api/inventory \
  -H "Content-Type: application/json" \
  -d '{
    "sku": "PROD-001",
    "name": "Premium Widget",
    "description": "High-quality widget",
    "price": 99.99,
    "quantity": 100
  }'
\`\`\`

### Create a Bill
\`\`\`bash
curl -X POST http://localhost:8080/api/billing \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": 1,
    "amount": 299.97,
    "status": "PENDING"
  }'
\`\`\`

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.2.0
- **Spring Cloud**: 2023.0.0
- **Spring Data JPA**: For database operations
- **Eureka**: Service discovery
- **Spring Cloud Gateway**: API Gateway
- **H2 Database**: In-memory database for development
- **Hibernate**: ORM framework

## Features

✅ Microservices architecture with Eureka service discovery  
✅ API Gateway for request routing  
✅ JPA/Hibernate for database operations  
✅ RESTful APIs for all services  
✅ H2 in-memory databases for each service  
✅ Clean code structure with proper package organization  
✅ Java 21 compatibility  
✅ Production-ready configuration  

## Author
Yasmine - Clean Java Code Project

## Notes
- All services use H2 in-memory databases (suitable for development/testing)
- For production, replace with PostgreSQL, MySQL, or other production databases
- Services auto-register with Eureka Discovery Service
- Gateway automatically discovers services and routes traffic
