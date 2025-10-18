import { useQuery } from '@tanstack/react-query';
import { speciesApi } from '../api/speciesApi';

export const useSpeciesById = (id: number) => {
  return useQuery({
    queryKey: ['species', id],
    queryFn: () => speciesApi.getSpeciesById(id),
    enabled: !!id, // Only run if id is provided
  });
};
