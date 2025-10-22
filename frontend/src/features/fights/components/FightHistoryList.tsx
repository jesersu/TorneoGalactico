import { useFights } from '../hooks/useFights';
import { Loading, ErrorMessage, Card } from '../../../shared/components';
import { Fight } from '../types/fight.types';

export const FightHistoryList = () => {
  const { data: fights, isLoading, error, refetch } = useFights();

  if (isLoading) {
    return <Loading message="Loading fight history..." />;
  }

  if (error) {
    return (
      <ErrorMessage
        message="Failed to load fight history. Please try again."
        onRetry={() => refetch()}
      />
    );
  }

  if (!fights || fights.length === 0) {
    return (
      <div className="text-center py-12">
        <p className="text-gray-500 text-lg">No fights yet.</p>
        <p className="text-gray-400 mt-2">Create your first fight to see the battle history!</p>
      </div>
    );
  }

  // Sort fights by date (newest first)
  const sortedFights = [...fights].sort((a, b) =>
    new Date(b.fightDate).getTime() - new Date(a.fightDate).getTime()
  );

  return (
    <div className="space-y-6">
      {sortedFights.map((fight) => (
        <FightHistoryCard key={fight.id} fight={fight} />
      ))}
    </div>
  );
};

interface FightHistoryCardProps {
  fight: Fight;
}

const FightHistoryCard = ({ fight }: FightHistoryCardProps) => {
  return (
    <Card className="bg-gradient-to-r from-blue-50 to-purple-50 border-l-4 border-purple-500">
      <div className="space-y-4">
        {/* Header with date */}
        <div className="flex justify-between items-center">
          <h3 className="text-lg font-bold text-gray-800">
            Battle #{fight.id}
          </h3>
          <span className="text-sm text-gray-500">
            {new Date(fight.fightDate).toLocaleDateString()} {new Date(fight.fightDate).toLocaleTimeString()}
          </span>
        </div>

        {/* Fighters */}
        <div className="grid grid-cols-3 gap-4">
          <div className={`p-3 rounded-lg text-center ${
            fight.winner.id === fight.species1.id
              ? 'bg-green-100 border-2 border-green-500'
              : 'bg-gray-100 border border-gray-300'
          }`}>
            <div className="font-bold text-md">{fight.species1.name}</div>
            <div className="text-sm text-gray-600">Power: {fight.species1.powerLevel}</div>
            <div className="text-xs text-gray-500 mt-1">{fight.species1.specialPower}</div>
            {fight.winner.id === fight.species1.id && (
              <div className="text-2xl mt-2">👑</div>
            )}
          </div>

          <div className="flex items-center justify-center">
            <span className="text-3xl">⚔️</span>
          </div>

          <div className={`p-3 rounded-lg text-center ${
            fight.winner.id === fight.species2.id
              ? 'bg-green-100 border-2 border-green-500'
              : 'bg-gray-100 border border-gray-300'
          }`}>
            <div className="font-bold text-md">{fight.species2.name}</div>
            <div className="text-sm text-gray-600">Power: {fight.species2.powerLevel}</div>
            <div className="text-xs text-gray-500 mt-1">{fight.species2.specialPower}</div>
            {fight.winner.id === fight.species2.id && (
              <div className="text-2xl mt-2">👑</div>
            )}
          </div>
        </div>

        {/* Battle Description */}
        <div className="bg-white rounded-lg p-4 shadow-sm">
          <h4 className="font-semibold text-gray-700 mb-2">Battle Description:</h4>
          <p className="text-gray-600 italic leading-relaxed">{fight.battleDescription}</p>
        </div>

        {/* Winner announcement */}
        <div className="text-center py-2 bg-gradient-to-r from-yellow-100 to-orange-100 rounded-lg">
          <span className="font-bold text-lg text-green-700">
            🏆 {fight.winner.name} emerged victorious!
          </span>
        </div>
      </div>
    </Card>
  );
};
