import { useState } from 'react';
import { FightForm, FightResult, Fight } from '../features/fights';
import { Button } from '../shared/components';
import { Link } from 'react-router-dom';

export const FightArenaPage = () => {
  const [lastFight, setLastFight] = useState<Fight | null>(null);

  return (
    <div className="min-h-screen bg-gradient-to-br from-red-400 to-orange-500 p-6">
      <div className="max-w-4xl mx-auto">
        <div className="flex justify-between items-center mb-8">
          <h1 className="text-4xl font-bold text-white">Battle Arena</h1>
          <Link to="/">
            <Button variant="secondary">Back to Home</Button>
          </Link>
        </div>

        <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
          <div>
            <FightForm onFightComplete={(fight) => setLastFight(fight)} />
          </div>

          {lastFight && (
            <div>
              <FightResult fight={lastFight} />
            </div>
          )}
        </div>

        {!lastFight && (
          <div className="mt-8 text-center text-white">
            <p className="text-xl">Select two species and start a battle!</p>
          </div>
        )}
      </div>
    </div>
  );
};
