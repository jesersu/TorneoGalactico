import { useState, FormEvent } from 'react';
import { Button, Input, Card } from '../../../shared/components';
import { useCreateSpecies } from '../hooks/useCreateSpecies';
import { SpeciesFormData } from '../types/species.types';

interface SpeciesFormProps {
  onSuccess?: () => void;
}

export const SpeciesForm = ({ onSuccess }: SpeciesFormProps) => {
  const [formData, setFormData] = useState<SpeciesFormData>({
    name: '',
    powerLevel: 1,
    specialPower: '',
  });

  const createMutation = useCreateSpecies();

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    createMutation.mutate(formData, {
      onSuccess: () => {
        setFormData({ name: '', powerLevel: 1, specialPower: '' });
        onSuccess?.();
      },
    });
  };

  const handleChange = (field: keyof SpeciesFormData, value: string | number) => {
    setFormData((prev) => ({ ...prev, [field]: value }));
  };

  return (
    <Card>
      <h2 className="text-2xl font-bold text-gray-800 mb-6">Create New Species</h2>

      <form onSubmit={handleSubmit} className="space-y-4">
        <Input
          label="Species Name"
          type="text"
          value={formData.name}
          onChange={(e) => handleChange('name', e.target.value)}
          placeholder="e.g., Dragon, Phoenix, Unicorn"
          required
        />

        <Input
          label="Power Level"
          type="number"
          min="1"
          max="10000"
          value={formData.powerLevel}
          onChange={(e) => handleChange('powerLevel', parseInt(e.target.value) || 1)}
          placeholder="1-10000"
          required
        />

        <div>
          <label className="block text-sm font-medium text-gray-700 mb-2">
            Special Power
          </label>
          <textarea
            value={formData.specialPower}
            onChange={(e) => handleChange('specialPower', e.target.value)}
            placeholder="Describe the species' special ability..."
            rows={4}
            className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            required
          />
        </div>

        <Button
          type="submit"
          variant="primary"
          isLoading={createMutation.isPending}
          className="w-full"
          disabled={!formData.name || !formData.specialPower}
        >
          Create Species
        </Button>
      </form>
    </Card>
  );
};
