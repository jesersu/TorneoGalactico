import { SpeciesRankingList } from '../features/species';
import { Button } from '../shared/components';
import { Link } from 'react-router-dom';

export const RankingPage = () => {
  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-5xl mx-auto">
        <div className="flex justify-between items-center mb-8">
          <div>
            <h1 className="text-4xl font-bold text-gray-800">Species Rankings</h1>
            <p className="text-gray-600 mt-2">Top fighters ranked by total victories</p>
          </div>
          <div className="flex gap-4">
            <Link to="/fight">
              <Button variant="primary">Start a Fight</Button>
            </Link>
            <Link to="/">
              <Button variant="secondary">Back to Home</Button>
            </Link>
          </div>
        </div>

        <div className="mb-6">
          <p className="text-gray-600">
            Species are ranked by their total number of victories in battles. The more fights they win,
            the higher they climb in the rankings!
          </p>
        </div>

        <div>
          <SpeciesRankingList />
        </div>
      </div>
    </div>
  );
};
