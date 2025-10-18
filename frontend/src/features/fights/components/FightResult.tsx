import { Card } from '../../../shared/components';
import { Fight } from '../types/fight.types';

interface FightResultProps {
  fight: Fight;
}

export const FightResult = ({ fight }: FightResultProps) => {
  return (
    <Card className="bg-gradient-to-r from-yellow-50 to-orange-50 border-2 border-yellow-300">
      <div className="text-center">
        <h3 className="text-2xl font-bold text-gray-800 mb-4">Battle Result</h3>

        <div className="grid grid-cols-3 gap-4 mb-6">
          <div className={`p-4 rounded-lg ${fight.winner.id === fight.species1.id ? 'bg-green-100 border-2 border-green-500' : 'bg-gray-100'}`}>
            <h4 className="font-bold text-lg">{fight.species1.name}</h4>
            <p className="text-sm text-gray-600">Power: {fight.species1.powerLevel}</p>
          </div>

          <div className="flex items-center justify-center">
            <span className="text-4xl">⚔️</span>
          </div>

          <div className={`p-4 rounded-lg ${fight.winner.id === fight.species2.id ? 'bg-green-100 border-2 border-green-500' : 'bg-gray-100'}`}>
            <h4 className="font-bold text-lg">{fight.species2.name}</h4>
            <p className="text-sm text-gray-600">Power: {fight.species2.powerLevel}</p>
          </div>
        </div>

        <div className="bg-white rounded-lg p-6 shadow-inner">
          <div className="text-6xl mb-4">👑</div>
          <h4 className="text-3xl font-bold text-green-600 mb-2">
            {fight.winner.name} Wins!
          </h4>
          <p className="text-gray-700 italic mt-4">{fight.battleDescription}</p>
        </div>

        <p className="text-xs text-gray-500 mt-4">
          Battle Date: {new Date(fight.fightDate).toLocaleString()}
        </p>
      </div>
    </Card>
  );
};
