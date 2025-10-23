import { apiClient } from '../../../core/api/axios.config';
import { Species, CreateSpeciesRequest, SpeciesRanking } from '../types/species.types';

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

  // Get species ranking by victories
  getSpeciesRanking: async (): Promise<SpeciesRanking[]> => {
    const response = await apiClient.get<SpeciesRanking[]>('/species/ranking');
    return response.data;
  },
};
