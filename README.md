# Morning Value Project

A full-stack application with React TypeScript + Tailwind CSS frontend and Spring Boot backend.

## Project Structure

```
morningValue/
├── frontend/          # React TypeScript app with Tailwind CSS
└── backend/           # Spring Boot Java application
```

## Frontend (React + TypeScript + Tailwind CSS)

### Prerequisites
- Node.js (v14 or higher)
- npm or yarn

### Setup and Run
```bash
cd frontend
npm install
npm start
```

The frontend will run on `http://localhost:3000`

### Features
- React 18 with TypeScript
- Tailwind CSS for styling
- API integration with Spring Boot backend
- Two demo endpoints:
  - GET request to fetch data
  - POST request to send data

## Backend (Spring Boot)

### Prerequisites
- Java 17 or higher
- Maven (will be downloaded automatically via Maven wrapper if not installed)

### Setup and Run

#### Option 1: Using Maven (if installed)
```bash
cd backend
mvn spring-boot:run
```

#### Option 2: Using Maven Wrapper (no Maven installation required)
```bash
cd backend
# On macOS/Linux
./mvnw spring-boot:run

# On Windows
mvnw.cmd spring-boot:run
```

#### Option 3: Using IDE
- Open the `backend` folder in IntelliJ IDEA or Eclipse
- Run the `BackendApplication.java` file

The backend will run on `http://localhost:8080`

### API Endpoints

- **GET** `/api/hello` - Returns a greeting message
- **POST** `/api/data` - Accepts JSON data and returns it

## Running the Full Stack

1. Start the backend:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

2. In a new terminal, start the frontend:
   ```bash
   cd frontend
   npm start
   ```

3. Open your browser to `http://localhost:3000`

## Configuration

### CORS
The backend is configured to accept requests from `http://localhost:3000` (frontend URL).

### Ports
- Frontend: 3000
- Backend: 8080

## Technologies Used

### Frontend
- React 18
- TypeScript
- Tailwind CSS
- Create React App

### Backend
- Spring Boot 3.2.0
- Java 17
- Maven
- Spring Web

## Development Notes

- The frontend makes API calls to the backend using the Fetch API
- CORS is already configured in the Spring Boot controller
- TypeScript interfaces ensure type safety for API responses
