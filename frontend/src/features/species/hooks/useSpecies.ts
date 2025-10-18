import { useQuery } from '@tanstack/react-query';
import { speciesApi } from '../api/speciesApi';

export const useSpecies = () => {
  return useQuery({
    queryKey: ['species'],
    queryFn: speciesApi.getAllSpecies,
  });
};
