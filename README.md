# Microservices with Spring Boot and Spring Cloud Gateway

This project demonstrates a microservices architecture using Spring Boot and Spring Cloud Gateway. It includes service discovery with Eureka, an API Gateway, and a User Service.

## Architecture

The project consists of the following components:

1. **Eureka Discovery Server** (Port: 8761)
   - Service registry and discovery server
   - Enables microservices to register and discover each other
   - Access the Eureka dashboard at http://localhost:8761

2. **API Gateway** (Port: 8765)
   - Built with Spring Cloud Gateway
   - Routes requests to appropriate microservices
   - Provides a single entry point for all client requests

3. **User Service** (Port: 8081)
   - Example microservice for user management
   - Registered with Eureka for service discovery

## Prerequisites

- Docker and Docker Compose
- Java 17 or later
- Maven

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/luradata/microservices-spring-cloud-gateway.git
   cd microservices-spring-cloud-gateway
   ```

2. Build and start the services:
   ```bash
   make up
   ```

3. Verify the services are running:
   ```bash
   make ps
   ```

## Available Commands

- `make up`: Start all services
- `make down`: Stop all services
- `make restart`: Restart all services
- `make logs`: View service logs
- `make ps`: List running services
- `make clean`: Clean up Docker images
- `make help`: Display available commands

## Service URLs

- Eureka Dashboard: http://localhost:8761
- API Gateway: http://localhost:8765
- User Service: http://localhost:8081

## Docker Network

All services are connected through a Docker network named `microservices-network`, enabling service-to-service communication.

## License

This project is licensed under the terms of the included [LICENSE](./LICENSE) file.
