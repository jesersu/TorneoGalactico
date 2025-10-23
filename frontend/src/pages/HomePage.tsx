import { Link } from 'react-router-dom';
import { Button } from '../shared/components';

export const HomePage = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-500 to-purple-600 flex items-center justify-center p-4">
      <div className="bg-white rounded-lg shadow-2xl p-12 max-w-2xl w-full text-center">
        <h1 className="text-5xl font-bold text-gray-800 mb-4">
          Morning Value
        </h1>
        <p className="text-2xl text-gray-600 mb-8">
          Species Fight Management System
        </p>

        <div className="space-y-4">
          <Link to="/species">
            <Button variant="primary" size="lg" className="w-full">
              View All Species
            </Button>
          </Link>

          <Link to="/fight">
            <Button variant="danger" size="lg" className="w-full">
              Start a Battle
            </Button>
          </Link>

          <Link to="/ranking">
            <Button variant="primary" size="lg" className="w-full">
              View Rankings
            </Button>
          </Link>

          <Link to="/fight-history">
            <Button variant="secondary" size="lg" className="w-full">
              View Fight History
            </Button>
          </Link>
        </div>

        <div className="mt-12 text-sm text-gray-500">
          <p>React + TypeScript + Clean Architecture</p>
          <p className="mt-1">Backend: Spring Boot with Clean Architecture</p>
        </div>
      </div>
    </div>
  );
};
