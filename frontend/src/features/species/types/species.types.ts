// Matches backend DTOs
export interface Species {
  id: number;
  name: string;
  powerLevel: number;
  specialPower: string;
}

export interface CreateSpeciesRequest {
  name: string;
  powerLevel: number;
  specialPower: string;
}

export interface SpeciesRanking {
  id: number;
  name: string;
  powerLevel: number;
  specialPower: string;
  victories: number;
}

export type SpeciesFormData = CreateSpeciesRequest;
