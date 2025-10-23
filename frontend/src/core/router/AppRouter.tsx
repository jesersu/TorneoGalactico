import { Routes, Route } from 'react-router-dom';
import { HomePage } from '../../pages/HomePage';
import { SpeciesListPage } from '../../pages/SpeciesListPage';
import { FightArenaPage } from '../../pages/FightArenaPage';
import { FightHistoryPage } from '../../pages/FightHistoryPage';
import { RankingPage } from '../../pages/RankingPage';

export const AppRouter = () => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/species" element={<SpeciesListPage />} />
      <Route path="/fight" element={<FightArenaPage />} />
      <Route path="/fight-history" element={<FightHistoryPage />} />
      <Route path="/ranking" element={<RankingPage />} />
      <Route path="*" element={<div className="p-8 text-center"><h1 className="text-2xl">404 - Page Not Found</h1></div>} />
    </Routes>
  );
};
