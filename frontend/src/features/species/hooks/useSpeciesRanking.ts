import { useQuery } from '@tanstack/react-query';
import { speciesApi } from '../api/speciesApi';

export const useSpeciesRanking = () => {
  return useQuery({
    queryKey: ['species', 'ranking'],
    queryFn: speciesApi.getSpeciesRanking,
  });
};
