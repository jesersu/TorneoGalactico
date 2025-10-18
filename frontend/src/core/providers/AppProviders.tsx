import { ReactNode } from 'react';
import { BrowserRouter } from 'react-router-dom';
import { QueryProvider } from './QueryProvider';

interface AppProvidersProps {
  children: ReactNode;
}

export const AppProviders = ({ children }: AppProvidersProps) => {
  return (
    <QueryProvider>
      <BrowserRouter>
        {children}
      </BrowserRouter>
    </QueryProvider>
  );
};

export default AppProviders;
