import { useSpeciesRanking } from '../hooks/useSpeciesRanking';
import { Loading, ErrorMessage, Card } from '../../../shared/components';
import { SpeciesRanking } from '../types/species.types';

export const SpeciesRankingList = () => {
  const { data: rankings, isLoading, error, refetch } = useSpeciesRanking();

  if (isLoading) {
    return <Loading message="Loading rankings..." />;
  }

  if (error) {
    return (
      <ErrorMessage
        message="Failed to load rankings. Please try again."
        onRetry={() => refetch()}
      />
    );
  }

  if (!rankings || rankings.length === 0) {
    return (
      <div className="text-center py-12">
        <p className="text-gray-500 text-lg">No species found.</p>
        <p className="text-gray-400 mt-2">Create species and have battles to see the rankings!</p>
      </div>
    );
  }

  return (
    <div className="space-y-4">
      {rankings.map((ranking, index) => (
        <RankingCard key={ranking.id} ranking={ranking} position={index + 1} />
      ))}
    </div>
  );
};

interface RankingCardProps {
  ranking: SpeciesRanking;
  position: number;
}

const RankingCard = ({ ranking, position }: RankingCardProps) => {
  const getMedalEmoji = (pos: number) => {
    switch (pos) {
      case 1:
        return '🥇';
      case 2:
        return '🥈';
      case 3:
        return '🥉';
      default:
        return '';
    }
  };

  const getPositionColor = (pos: number) => {
    switch (pos) {
      case 1:
        return 'from-yellow-50 to-yellow-100 border-yellow-400';
      case 2:
        return 'from-gray-50 to-gray-100 border-gray-400';
      case 3:
        return 'from-orange-50 to-orange-100 border-orange-400';
      default:
        return 'from-blue-50 to-blue-100 border-blue-300';
    }
  };

  return (
    <Card className={`bg-gradient-to-r ${getPositionColor(position)} border-l-4`}>
      <div className="flex items-center justify-between">
        <div className="flex items-center gap-6 flex-1">
          {/* Position */}
          <div className="flex items-center justify-center w-16 h-16">
            {position <= 3 ? (
              <span className="text-4xl">{getMedalEmoji(position)}</span>
            ) : (
              <span className="text-3xl font-bold text-gray-600">#{position}</span>
            )}
          </div>

          {/* Species Info */}
          <div className="flex-1">
            <h3 className="text-2xl font-bold text-gray-800">{ranking.name}</h3>
            <div className="flex gap-6 mt-2">
              <div className="text-sm">
                <span className="text-gray-600">Power Level: </span>
                <span className="font-semibold text-purple-600">{ranking.powerLevel}</span>
              </div>
              <div className="text-sm">
                <span className="text-gray-600">Special Power: </span>
                <span className="font-semibold text-blue-600">{ranking.specialPower}</span>
              </div>
            </div>
          </div>

          {/* Victory Count */}
          <div className="text-center px-6 py-3 bg-white rounded-lg shadow-sm border-2 border-green-300">
            <div className="text-3xl font-bold text-green-600">{ranking.victories}</div>
            <div className="text-xs text-gray-600 mt-1">
              {ranking.victories === 1 ? 'Victory' : 'Victories'}
            </div>
          </div>
        </div>
      </div>
    </Card>
  );
};
