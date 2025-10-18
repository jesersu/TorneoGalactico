import { useState, FormEvent } from 'react';
import { Button, Card } from '../../../shared/components';
import { useSpecies } from '../../species/hooks/useSpecies';
import { useCreateFight } from '../hooks/useCreateFight';
import { Fight } from '../types/fight.types';

interface FightFormProps {
  onFightComplete?: (fight: Fight) => void;
}

export const FightForm = ({ onFightComplete }: FightFormProps) => {
  const [species1Id, setSpecies1Id] = useState<number | ''>('');
  const [species2Id, setSpecies2Id] = useState<number | ''>('');

  const { data: species, isLoading: loadingSpecies } = useSpecies();
  const createFightMutation = useCreateFight();

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();

    if (species1Id === '' || species2Id === '') return;
    if (species1Id === species2Id) {
      alert('A species cannot fight itself!');
      return;
    }

    createFightMutation.mutate(
      {
        species1Id: Number(species1Id),
        species2Id: Number(species2Id),
      },
      {
        onSuccess: (fight) => {
          onFightComplete?.(fight);
          setSpecies1Id('');
          setSpecies2Id('');
        },
      }
    );
  };

  if (loadingSpecies) {
    return <p>Loading species...</p>;
  }

  if (!species || species.length < 2) {
    return (
      <Card>
        <p className="text-gray-600 text-center">
          You need at least 2 species to start a fight. Please create more species first.
        </p>
      </Card>
    );
  }

  return (
    <Card>
      <h2 className="text-2xl font-bold text-gray-800 mb-6">Start a Battle</h2>

      <form onSubmit={handleSubmit} className="space-y-6">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-2">
            First Fighter
          </label>
          <select
            value={species1Id}
            onChange={(e) => setSpecies1Id(e.target.value ? Number(e.target.value) : '')}
            className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            required
          >
            <option value="">Select a species...</option>
            {species.map((s) => (
              <option key={s.id} value={s.id}>
                {s.name} (Power: {s.powerLevel})
              </option>
            ))}
          </select>
        </div>

        <div className="flex items-center justify-center">
          <span className="text-3xl font-bold text-gray-400">VS</span>
        </div>

        <div>
          <label className="block text-sm font-medium text-gray-700 mb-2">
            Second Fighter
          </label>
          <select
            value={species2Id}
            onChange={(e) => setSpecies2Id(e.target.value ? Number(e.target.value) : '')}
            className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            required
          >
            <option value="">Select a species...</option>
            {species.map((s) => (
              <option key={s.id} value={s.id} disabled={s.id === species1Id}>
                {s.name} (Power: {s.powerLevel})
              </option>
            ))}
          </select>
        </div>

        <Button
          type="submit"
          variant="danger"
          isLoading={createFightMutation.isPending}
          className="w-full text-lg py-4"
          disabled={!species1Id || !species2Id}
        >
          {createFightMutation.isPending ? 'Battle in Progress...' : 'Start Battle!'}
        </Button>
      </form>
    </Card>
  );
};
