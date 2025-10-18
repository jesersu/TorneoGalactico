import { AppProviders } from './core/providers/AppProviders';
import { AppRouter } from './core/router/AppRouter';
import './App.css';

function App() {
  return (
    <AppProviders>
      <AppRouter />
    </AppProviders>
  );
}

export default App;
