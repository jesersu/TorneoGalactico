import { Species } from '../../species/types/species.types';

// Matches backend DTOs
export interface Fight {
  id: number;
  species1: Species;
  species2: Species;
  winner: Species;
  fightDate: string;
  battleDescription: string;
}

export interface CreateFightRequest {
  species1Id: number;
  species2Id: number;
}
