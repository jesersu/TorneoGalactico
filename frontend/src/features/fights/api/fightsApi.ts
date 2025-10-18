import { apiClient } from '../../../core/api/axios.config';
import { Fight, CreateFightRequest } from '../types/fight.types';

export const fightsApi = {
  // Create a new fight
  createFight: async (data: CreateFightRequest): Promise<Fight> => {
    const response = await apiClient.post<Fight>('/fights', data);
    return response.data;
  },
};
