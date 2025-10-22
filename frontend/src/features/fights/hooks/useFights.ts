import { useQuery } from '@tanstack/react-query';
import { fightsApi } from '../api/fightsApi';

export const useFights = () => {
  return useQuery({
    queryKey: ['fights'],
    queryFn: fightsApi.getAllFights,
  });
};
