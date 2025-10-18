import { useMutation } from '@tanstack/react-query';
import { fightsApi } from '../api/fightsApi';
import { CreateFightRequest } from '../types/fight.types';
import { useGlobalStore } from '../../../core/store/useGlobalStore';

export const useCreateFight = () => {
  const setNotification = useGlobalStore((state) => state.setNotification);

  return useMutation({
    mutationFn: (data: CreateFightRequest) => fightsApi.createFight(data),
    onSuccess: () => {
      setNotification({
        message: 'Battle complete!',
        type: 'success',
      });
    },
    onError: (error: any) => {
      setNotification({
        message: error.response?.data?.message || 'Failed to create fight',
        type: 'error',
      });
    },
  });
};
