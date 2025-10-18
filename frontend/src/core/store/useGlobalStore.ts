import { create } from 'zustand';
import { devtools } from 'zustand/middleware';

interface GlobalState {
  // UI State
  isLoading: boolean;
  setIsLoading: (loading: boolean) => void;

  // Notifications/Toast
  notification: { message: string; type: 'success' | 'error' | 'info' } | null;
  setNotification: (notification: GlobalState['notification']) => void;
  clearNotification: () => void;

  // Theme (future)
  theme: 'light' | 'dark';
  toggleTheme: () => void;
}

export const useGlobalStore = create<GlobalState>()(
  devtools(
    (set) => ({
      // UI State
      isLoading: false,
      setIsLoading: (loading) => set({ isLoading: loading }),

      // Notifications
      notification: null,
      setNotification: (notification) => set({ notification }),
      clearNotification: () => set({ notification: null }),

      // Theme
      theme: 'light',
      toggleTheme: () =>
        set((state) => ({ theme: state.theme === 'light' ? 'dark' : 'light' })),
    }),
    { name: 'global-store' }
  )
);
