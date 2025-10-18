import { useState } from 'react';
import { SpeciesList, SpeciesForm } from '../features/species';
import { Button } from '../shared/components';
import { Link } from 'react-router-dom';

export const SpeciesListPage = () => {
  const [showForm, setShowForm] = useState(false);

  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-7xl mx-auto">
        <div className="flex justify-between items-center mb-8">
          <h1 className="text-4xl font-bold text-gray-800">Species Management</h1>
          <Link to="/">
            <Button variant="secondary">Back to Home</Button>
          </Link>
        </div>

        <div className="mb-8">
          <Button
            variant={showForm ? 'secondary' : 'primary'}
            onClick={() => setShowForm(!showForm)}
          >
            {showForm ? 'Hide Form' : 'Create New Species'}
          </Button>
        </div>

        {showForm && (
          <div className="mb-8">
            <SpeciesForm onSuccess={() => setShowForm(false)} />
          </div>
        )}

        <div>
          <h2 className="text-2xl font-bold text-gray-700 mb-4">All Species</h2>
          <SpeciesList />
        </div>
      </div>
    </div>
  );
};
