# Morning Value Frontend - React TypeScript Clean Architecture

A modern React TypeScript frontend implementing Clean Architecture principles to match the backend structure.

## Quick Start

```bash
# Install dependencies
npm install

# Start development server
npm start

# Build for production
npm run build

# Run tests
npm test
```

The application will be available at `http://localhost:3000`

## Prerequisites

- Node.js 16+
- npm or yarn
- Backend running on `http://localhost:8080`

## Features

- ✅ View all species
- ✅ Create new species
- ✅ Battle species against each other
- ✅ View battle results
- ✅ Clean, modern UI with Tailwind CSS

## Tech Stack

- **React 19** - UI library
- **TypeScript** - Type safety
- **TanStack Query** - Server state management
- **Zustand** - Global client state
- **React Router** - Navigation
- **Axios** - HTTP client
- **Tailwind CSS** - Styling

## Project Structure

```
src/
├── features/          # Feature modules (species, fights)
├── shared/            # Shared components & utilities
├── core/              # Core infrastructure (API, providers, store)
├── pages/             # Page components
└── App.tsx            # Main application component
```

For detailed architecture documentation, see [ARCHITECTURE.md](./ARCHITECTURE.md)

## Environment Variables

Create a `.env` file in the root directory:

```env
REACT_APP_API_BASE_URL=http://localhost:8080
```

## Available Scripts

| Command | Description |
|---------|-------------|
| `npm start` | Start development server (port 3000) |
| `npm build` | Build for production |
| `npm test` | Run test suite |
| `npm run eject` | Eject from Create React App (one-way!) |

## Pages

### Home Page (`/`)
Landing page with navigation to features

### Species List (`/species`)
- View all species
- Create new species
- See power levels and special powers

### Fight Arena (`/fight`)
- Select two species
- Start battle
- View battle results

## API Integration

All API calls go through the Axios client configured in `src/core/api/axios.config.ts`

**Base URL:** Configured via `REACT_APP_API_BASE_URL` environment variable

**Endpoints Used:**
- `GET /api/species` - Get all species
- `GET /api/species/:id` - Get species by ID
- `POST /api/species` - Create new species
- `POST /api/fights` - Create a fight

## State Management

### Server State (React Query)
Handles all backend data with automatic caching, refetching, and synchronization.

### Global Client State (Zustand)
Manages UI state like notifications, loading indicators, and theme.

### Local Component State (useState)
Handles component-specific UI state.

## Adding New Features

1. Create feature folder: `src/features/your-feature/`
2. Add types: `types/your-feature.types.ts`
3. Create API layer: `api/yourFeatureApi.ts`
4. Build hooks: `hooks/useYourFeature.ts`
5. Design components: `components/YourComponent.tsx`
6. Export public API: `index.ts`

## Development Best Practices

1. **Types First**: Define TypeScript types matching backend DTOs
2. **API Layer**: Keep all API calls in dedicated API files
3. **Custom Hooks**: Wrap React Query in feature-specific hooks
4. **Component Composition**: Build UIs from small, reusable components
5. **Error Handling**: Handle errors at component level with fallback UI

## Common Issues

### "Failed to connect to backend"
- Ensure backend is running on port 8080
- Check `REACT_APP_API_BASE_URL` in `.env`
- Verify CORS is enabled in backend

### "Species not loading"
- Check browser console for errors
- Verify backend `/api/species` endpoint is working
- Check React Query DevTools (if enabled)

## Code Style

- **Functional Components**: Use function components with hooks
- **TypeScript**: Strict mode enabled
- **Formatting**: Prettier (auto-format on save recommended)
- **Naming**:
  - Components: PascalCase (`SpeciesList.tsx`)
  - Hooks: camelCase with `use` prefix (`useSpecies.ts`)
  - Files: Match component/hook name

## Testing

```bash
# Run all tests
npm test

# Run with coverage
npm test -- --coverage

# Run specific test file
npm test SpeciesList.test.tsx
```

## Building for Production

```bash
npm run build
```

Creates optimized production build in `build/` folder.

**Deploy:**
- Static hosting: Netlify, Vercel, GitHub Pages
- CDN: CloudFront, Fastly
- Server: Nginx, Apache

## Architecture Highlights

✅ **Clean Architecture**: Matches backend structure
✅ **Feature-Based**: Organized by business domain
✅ **Type-Safe**: Full TypeScript coverage
✅ **Scalable**: Easy to add new features
✅ **Testable**: Isolated components and hooks
✅ **Modern**: Latest React patterns and libraries

## Related Documentation

- [ARCHITECTURE.md](./ARCHITECTURE.md) - Detailed architecture guide
- [Backend README](../backend/README.md) - Backend documentation

## Contributing

1. Follow the existing architecture patterns
2. Add types for all new features
3. Write tests for critical paths
4. Update documentation

## License

Private project for Morning Value interview.
