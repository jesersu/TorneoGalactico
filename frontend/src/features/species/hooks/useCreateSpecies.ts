import { useMutation, useQueryClient } from '@tanstack/react-query';
import { speciesApi } from '../api/speciesApi';
import { CreateSpeciesRequest } from '../types/species.types';
import { useGlobalStore } from '../../../core/store/useGlobalStore';

export const useCreateSpecies = () => {
  const queryClient = useQueryClient();
  const setNotification = useGlobalStore((state) => state.setNotification);

  return useMutation({
    mutationFn: (data: CreateSpeciesRequest) => speciesApi.createSpecies(data),
    onSuccess: () => {
      // Invalidate and refetch species list
      queryClient.invalidateQueries({ queryKey: ['species'] });
      setNotification({
        message: 'Species created successfully!',
        type: 'success',
      });
    },
    onError: (error: any) => {
      setNotification({
        message: error.response?.data?.message || 'Failed to create species',
        type: 'error',
      });
    },
  });
};
