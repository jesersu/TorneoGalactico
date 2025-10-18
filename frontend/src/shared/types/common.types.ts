export interface ApiError {
  message: string;
  status?: number;
  timestamp?: string;
  error?: string;
}

export interface PaginationParams {
  page: number;
  size: number;
}

export interface ApiResponse<T> {
  data: T;
  message?: string;
}
