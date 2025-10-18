import { Card } from '../../../shared/components';
import { Species } from '../types/species.types';

interface SpeciesCardProps {
  species: Species;
  onClick?: (species: Species) => void;
}

export const SpeciesCard = ({ species, onClick }: SpeciesCardProps) => {
  return (
    <Card onClick={() => onClick?.(species)} className="hover:border-blue-300 border-2 border-transparent">
      <div className="flex flex-col">
        <h3 className="text-xl font-bold text-gray-800 mb-2">{species.name}</h3>

        <div className="flex items-center mb-3">
          <span className="text-sm font-medium text-gray-600 mr-2">Power Level:</span>
          <div className="flex items-center">
            <div className="bg-blue-100 rounded-full px-3 py-1">
              <span className="text-blue-700 font-bold">{species.powerLevel}</span>
            </div>
          </div>
        </div>

        <div className="bg-gradient-to-r from-purple-50 to-pink-50 p-3 rounded-lg">
          <p className="text-sm font-medium text-gray-600 mb-1">Special Power:</p>
          <p className="text-gray-800">{species.specialPower}</p>
        </div>
      </div>
    </Card>
  );
};
