import { useSpecies } from '../hooks/useSpecies';
import { Loading, ErrorMessage } from '../../../shared/components';
import { SpeciesCard } from './SpeciesCard';
import { Species } from '../types/species.types';

interface SpeciesListProps {
  onSpeciesClick?: (species: Species) => void;
}

export const SpeciesList = ({ onSpeciesClick }: SpeciesListProps) => {
  const { data: species, isLoading, error, refetch } = useSpecies();

  if (isLoading) {
    return <Loading message="Loading species..." />;
  }

  if (error) {
    return (
      <ErrorMessage
        message="Failed to load species. Please try again."
        onRetry={() => refetch()}
      />
    );
  }

  if (!species || species.length === 0) {
    return (
      <div className="text-center py-12">
        <p className="text-gray-500 text-lg">No species found.</p>
        <p className="text-gray-400 mt-2">Create your first species to get started!</p>
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
      {species.map((s) => (
        <SpeciesCard key={s.id} species={s} onClick={onSpeciesClick} />
      ))}
    </div>
  );
};
