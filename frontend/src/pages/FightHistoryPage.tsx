import { FightHistoryList } from '../features/fights';
import { Button } from '../shared/components';
import { Link } from 'react-router-dom';

export const FightHistoryPage = () => {
  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-7xl mx-auto">
        <div className="flex justify-between items-center mb-8">
          <h1 className="text-4xl font-bold text-gray-800">Fight History</h1>
          <div className="flex gap-4">
            <Link to="/fight">
              <Button variant="primary">Create New Fight</Button>
            </Link>
            <Link to="/">
              <Button variant="secondary">Back to Home</Button>
            </Link>
          </div>
        </div>

        <div className="mb-6">
          <p className="text-gray-600">
            View all past battles and their epic descriptions. Each fight shows the combatants,
            the winner, and the dramatic story of how the battle unfolded.
          </p>
        </div>

        <div>
          <FightHistoryList />
        </div>
      </div>
    </div>
  );
};
