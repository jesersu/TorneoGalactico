# Morning Value - Species Fight Management System

A full-stack application demonstrating **Clean Architecture** principles across both frontend and backend tiers. Create powerful species, engage them in epic battles, track fight history, and climb the rankings.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-19-blue.svg)](https://reactjs.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-4.9-blue.svg)](https://www.typescriptlang.org/)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)

## Features

- **Species Management** - Create and manage unique species with custom power levels and special abilities
- **Battle Arena** - Simulate fights between species using power-based probability algorithms
- **Live Rankings** - Track win/loss records and see which species dominate the battlefield
- **Battle History** - Review detailed fight outcomes and battle descriptions
- **Real-time Statistics** - Dashboard showing total species, battles, and latest victor
- **Modern UI** - Dark-themed interface with smooth animations and responsive design

## Quick Start

### With Docker (Recommended)

**Development Mode** (with hot-reload):
```bash
# Start all services (PostgreSQL, Backend, Frontend)
docker-compose up --build

# Access the application
open http://localhost:3000
```

**Production Mode**:
```bash
# Set required environment variable
export DATABASE_PASSWORD=your_secure_password

# Start production stack
docker-compose -f docker-compose.prod.yml up --build

# Access via Nginx
open http://localhost:80
```

### Without Docker

**Prerequisites**: Node.js 14+, Java 21, PostgreSQL 15

```bash
# Terminal 1 - Start PostgreSQL (or use existing instance)
# Update backend/src/main/resources/application-dev.properties with your DB config

# Terminal 2 - Start Backend
cd backend
./mvnw spring-boot:run

# Terminal 3 - Start Frontend
cd frontend
npm install
npm start

# Access at http://localhost:3000
```

## Project Structure

```
morningValue/
├── frontend/                     # React TypeScript application
│   ├── src/
│   │   ├── features/            # Feature-based modules
│   │   │   ├── species/         # Species domain
│   │   │   │   ├── api/         # API calls (Axios)
│   │   │   │   ├── hooks/       # React Query hooks
│   │   │   │   ├── components/  # UI components
│   │   │   │   └── types/       # TypeScript types
│   │   │   └── fights/          # Fights domain
│   │   ├── pages/               # Route compositions
│   │   ├── shared/              # Reusable components
│   │   └── core/                # API config, router, providers
│   ├── Dockerfile               # Multi-stage build
│   └── nginx.conf               # Production serving
│
├── backend/                      # Spring Boot application
│   ├── src/main/java/com/morningvalue/
│   │   ├── domain/              # Core business logic (framework-agnostic)
│   │   │   ├── entity/          # Domain entities (POJOs)
│   │   │   ├── repository/      # Repository interfaces
│   │   │   └── exception/       # Business exceptions
│   │   ├── application/         # Use cases & orchestration
│   │   │   ├── usecase/         # Single-purpose operations
│   │   │   ├── service/         # Application services
│   │   │   └── dto/             # Data transfer objects
│   │   ├── infrastructure/      # Technical implementations
│   │   │   └── persistence/     # JPA entities, repos, mappers
│   │   └── presentation/        # REST API layer
│   │       └── controller/      # HTTP endpoints
│   ├── Dockerfile               # Multi-stage build
│   └── docker-compose.yml       # Backend + DB only
│
├── docker-compose.yml           # Development stack
├── docker-compose.prod.yml      # Production stack
└── DOCKER_SETUP.md              # Detailed Docker documentation
```

## Architecture

### Backend: Clean Architecture with Feature-Based Organization

**Dependency Flow**: Presentation → Application → Domain ← Infrastructure

**Layer Responsibilities**:
- **Domain**: Pure business logic, entities, repository interfaces (no framework dependencies)
- **Application**: Use cases, services, DTOs (orchestrates business operations)
- **Infrastructure**: JPA implementations, database mappers (technical details)
- **Presentation**: REST controllers, exception handlers (HTTP layer)

**Key Principles**:
- Domain entities are pure POJOs
- Separate JPA entities from domain entities (mapped via mappers)
- Dependency inversion (domain defines interfaces, infrastructure implements)
- Single-purpose use cases

### Frontend: Feature-Based Clean Architecture

**Layer Structure**: Pages → Features → Shared → Core

**State Management**:
- **Server State**: React Query (TanStack Query) for API data
- **Global Client State**: Zustand for notifications, theme, modals
- **Local State**: useState for form inputs and toggles

**Feature Encapsulation**:
- Each feature exports only its public API via `index.ts`
- Self-contained modules with types, API, hooks, components
- Types match backend DTOs exactly for contract alignment

## API Endpoints

### Species
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/species` | Create a new species |
| GET | `/api/species` | Get all species |
| GET | `/api/species/{id}` | Get species by ID |
| GET | `/api/species/ranking` | Get species ranked by wins |

### Fights
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/fights` | Create a fight between two species |
| GET | `/api/fights` | Get all fights |
| GET | `/api/fights/{id}` | Get fight by ID |

**Request Example**:
```json
POST /api/species
{
  "name": "Dragon",
  "powerLevel": 9500,
  "specialPower": "Fire Breath"
}

POST /api/fights
{
  "species1Id": 1,
  "species2Id": 2
}
```

## Technology Stack

### Frontend
- **React 19** - UI library
- **TypeScript 4.9** - Type safety
- **TanStack Query** - Server state management
- **Zustand** - Global client state
- **React Router 6** - Navigation
- **Axios** - HTTP client
- **Tailwind CSS** - Utility-first styling

### Backend
- **Spring Boot 3.2.0** - Application framework
- **Java 21** - Programming language
- **PostgreSQL 15** - Production database
- **H2** - In-memory database for tests
- **JPA/Hibernate** - ORM
- **Lombok** - Boilerplate reduction
- **Maven** - Build tool

### DevOps
- **Docker & Docker Compose** - Containerization
- **Nginx** - Production web server & reverse proxy
- **Multi-stage Dockerfiles** - Optimized builds

## Configuration

### Environment Variables

**Backend** (Production):
```bash
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=jdbc:postgresql://host:5432/dbname
DATABASE_USERNAME=username
DATABASE_PASSWORD=password
```

**Development**: Safe defaults in `application-dev.properties` (no env vars required)

### Database

- **Development**: PostgreSQL 15 via Docker
- **Test**: H2 in-memory database
- **Schema**: Auto-created in dev (`spring.jpa.hibernate.ddl-auto=update`)

### Ports

| Service | Development | Production |
|---------|-------------|------------|
| Frontend | 3000 | 80 (via Nginx) |
| Backend | 8080 | 8080 (internal) |
| PostgreSQL | 5432 | 5432 (internal) |

## Development

### Running Tests

```bash
# Backend unit tests
cd backend
./mvnw test

# Frontend tests
cd frontend
npm test

# Frontend coverage
npm test -- --coverage
```

### Code Style

- **Backend**: Follow Clean Architecture principles, domain entities must be framework-agnostic
- **Frontend**: Feature encapsulation, types match backend DTOs, hooks for all data fetching
- **Both**: Use environment variables for configuration, never commit secrets

## Docker Documentation

For comprehensive Docker setup, networking, troubleshooting, and best practices, see:
- **[DOCKER_SETUP.md](DOCKER_SETUP.md)** - Complete Docker guide
- **[CLAUDE.md](CLAUDE.md)** - Development guide for Claude Code

## Common Issues

**"Connection to localhost:5432 refused"**: Backend trying to connect to localhost instead of Docker service
```bash
cd backend
docker-compose down
docker-compose build --no-cache
docker-compose up
```

**"Could not resolve placeholder 'DATABASE_URL'"**: Running in prod mode without env vars
```bash
export SPRING_PROFILES_ACTIVE=dev
# OR set required environment variables
```

**Port already in use**:
```bash
# Find and stop conflicting process
lsof -i :8080
lsof -i :3000
```
Thank you for the oportunity.