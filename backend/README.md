# Morning Value Backend - Species Fight Management System

A clean architecture implementation of a species fight management system built with Spring Boot, PostgreSQL, and Docker.

## Architecture

This project follows **Clean Architecture** principles with clear separation of concerns across four layers:

```
├── domain/                    # Business entities and rules (innermost layer)
│   ├── entity/               # Core business entities (Species, Fight)
│   ├── repository/           # Repository interfaces
│   └── exception/            # Domain exceptions
├── application/              # Application business logic
│   ├── usecase/             # Use cases implementing business logic
│   ├── service/             # Application services orchestrating use cases
│   └── dto/                 # Data Transfer Objects
├── infrastructure/           # External concerns (database, frameworks)
│   ├── persistence/
│   │   ├── entity/          # JPA entities
│   │   ├── repository/      # JPA repository implementations
│   │   └── mapper/          # Entity ↔ Domain mappers
│   └── config/              # Infrastructure configuration
└── presentation/            # API layer (outermost layer)
    ├── controller/          # REST controllers
    ├── dto/                 # API request/response DTOs
    └── exception/           # Global exception handlers
```

### Key Principles

- **Dependency Rule**: Dependencies point inward. Domain layer has no dependencies on outer layers.
- **Separation of Concerns**: Each layer has a specific responsibility.
- **Testability**: Business logic is independent of frameworks and databases.
- **Flexibility**: Easy to swap implementations (e.g., change database or framework).

## Features

- Create and manage species with name, power level, and special powers
- Battle system between species with power-based probability
- RESTful API with proper error handling
- PostgreSQL database with JPA/Hibernate
- Docker containerization
- Unit tests for business logic

## Technology Stack

- Java 21
- Spring Boot 3.2.0
- PostgreSQL 16
- Maven 3.9.5
- Docker & Docker Compose
- JUnit 5 & Mockito
- Lombok

## API Endpoints

### Species Management

- `POST /api/species` - Create a new species
- `GET /api/species` - Get all species
- `GET /api/species/{id}` - Get species by ID

### Fight Management

- `POST /api/fights` - Create a fight between two species

### Sample Requests

**Create Species:**
```json
POST /api/species
{
  "name": "Dragon",
  "powerLevel": 9000,
  "specialPower": "Fire breath"
}
```

**Create Fight:**
```json
POST /api/fights
{
  "species1Id": 1,
  "species2Id": 2
}
```

## Configuration & Security

### Environment Profiles

This application uses Spring Profiles for environment-specific configuration:

- **dev** (default): Development profile with safe default credentials
- **prod**: Production profile requiring environment variables

**Important:** See [SECURITY.md](SECURITY.md) for complete security documentation.

### Environment Variables

For **production**, you MUST set these environment variables:

```bash
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=jdbc:postgresql://your-host:5432/your-database
DATABASE_USERNAME=your_username
DATABASE_PASSWORD=your_secure_password
```

For **development**, these are optional (defaults provided in `application-dev.properties`).

### Configuration Files

- `application.properties` - Common settings
- `application-dev.properties` - Development defaults (safe for Git)
- `application-prod.properties` - Production settings (requires env vars)
- `.env.example` - Template for local environment variables
- `.env` - **Your local secrets (NOT committed to Git)**

## Running the Application

### Prerequisites

- Docker and Docker Compose installed
- Java 21 (if running locally without Docker)
- Maven 3.9+ (if running locally without Docker)

### Using Docker Compose (Recommended)

```bash
cd backend
docker-compose up --build
```

This will:
- Start PostgreSQL container on port 5432
- Build and start the Spring Boot application on port 8080
- Create the necessary database and tables automatically

### Running Locally

1. Start PostgreSQL database:
```bash
docker run -d \
  --name postgres \
  -e POSTGRES_DB=morningvalue \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:16-alpine
```

2. Run the application:
```bash
mvn spring-boot:run
```

### Running Tests

```bash
mvn test
```

## Environment Variables Reference

### Required in Production

| Variable | Description | Example |
|----------|-------------|---------|
| `SPRING_PROFILES_ACTIVE` | Active Spring profile | `prod` |
| `DATABASE_URL` | JDBC connection URL | `jdbc:postgresql://db:5432/morningvalue` |
| `DATABASE_USERNAME` | Database username | `app_user` |
| `DATABASE_PASSWORD` | Database password | `strong_password_here` |

### Optional

| Variable | Description | Default |
|----------|-------------|---------|
| `CORS_ALLOWED_ORIGINS` | Allowed CORS origins | `http://localhost:3000` |
| `SERVER_PORT` | Application port | `8080` |

**Security Note:** Never commit actual credentials to Git. Use environment variables or a secrets manager.

## Database Schema

The application automatically creates the following tables:

**species:**
- id (BIGINT, Primary Key)
- name (VARCHAR, Unique)
- power_level (INTEGER)
- special_power (VARCHAR)

**fights:**
- id (BIGINT, Primary Key)
- species1_id (BIGINT, Foreign Key)
- species2_id (BIGINT, Foreign Key)
- winner_id (BIGINT, Foreign Key)
- fight_date (TIMESTAMP)
- battle_description (VARCHAR)

## Project Structure Benefits

1. **Domain Layer**: Pure business logic with no external dependencies
2. **Application Layer**: Use cases that can be tested independently
3. **Infrastructure Layer**: Isolated database and framework concerns
4. **Presentation Layer**: Clean REST API separated from business logic

This structure makes the codebase:
- Easy to test (mock repositories in use case tests)
- Easy to maintain (clear boundaries between layers)
- Easy to extend (add new use cases without touching infrastructure)
- Framework independent (can switch from Spring to another framework)

## Development Notes

- The application uses Hibernate DDL auto-update for **development only**
- SQL queries are logged in debug mode in **dev profile**
- Connection pooling is configured with HikariCP
- CORS is enabled for `http://localhost:3000` (frontend integration)

## Security Best Practices

This application follows security best practices:

✅ **Environment-based configuration** - Sensitive data via environment variables
✅ **Profile separation** - Different configs for dev/prod
✅ **No hardcoded secrets** - Credentials never in source code
✅ **Production safeguards** - Strict validation, minimal logging
✅ **Git protection** - .env files ignored automatically

**Read [SECURITY.md](SECURITY.md) for complete security documentation.**

### Quick Security Checklist

Before deploying to production:

- [ ] Set `SPRING_PROFILES_ACTIVE=prod`
- [ ] Provide all required environment variables
- [ ] Use strong, unique database passwords
- [ ] Enable SSL/TLS for database connections
- [ ] Review and restrict CORS origins
- [ ] Set up database backups
- [ ] Configure monitoring and logging

## Future Enhancements

- Add participant ranking system based on fight results
- Implement fight history tracking
- Add user authentication and authorization
- Create battle statistics and analytics
- Implement pagination for large datasets
