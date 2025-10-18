import { apiClient } from '../../../core/api/axios.config';
import { Species, CreateSpeciesRequest } from '../types/species.types';

export const speciesApi = {
  // Get all species
  getAllSpecies: async (): Promise<Species[]> => {
    const response = await apiClient.get<Species[]>('/species');
    return response.data;
  },

  // Get species by ID
  getSpeciesById: async (id: number): Promise<Species> => {
    const response = await apiClient.get<Species>(`/species/${id}`);
    return response.data;
  },

  // Create new species
  createSpecies: async (data: CreateSpeciesRequest): Promise<Species> => {
    const response = await apiClient.post<Species>('/species', data);
    return response.data;
  },
};
