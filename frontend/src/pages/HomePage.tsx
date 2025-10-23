import { Link } from 'react-router-dom';
import { Card, Loading } from '../shared/components';
import { useSpecies } from '../features/species';
import { useFights } from '../features/fights';

export const HomePage = () => {
  const { data: species, isLoading: speciesLoading } = useSpecies();
  const { data: fights, isLoading: fightsLoading } = useFights();

  const totalSpecies = species?.length || 0;
  const totalFights = fights?.length || 0;
  const latestFight = fights?.[fights.length - 1];

  const featureCards = [
    {
      icon: '🦎',
      title: 'Manage Species',
      description: 'Create and view all species in the system',
      path: '/species',
      color: 'from-blue-500 to-blue-600',
      hoverColor: 'hover:from-blue-600 hover:to-blue-700',
    },
    {
      icon: '⚔️',
      title: 'Battle Arena',
      description: 'Pit species against each other in epic battles',
      path: '/fight',
      color: 'from-red-500 to-red-600',
      hoverColor: 'hover:from-red-600 hover:to-red-700',
    },
    {
      icon: '🏆',
      title: 'Rankings',
      description: 'See which species dominate the battlefield',
      path: '/ranking',
      color: 'from-yellow-500 to-yellow-600',
      hoverColor: 'hover:from-yellow-600 hover:to-yellow-700',
    },
    {
      icon: '📜',
      title: 'Battle History',
      description: 'Review past fights and their outcomes',
      path: '/fight-history',
      color: 'from-purple-500 to-purple-600',
      hoverColor: 'hover:from-purple-600 hover:to-purple-700',
    },
  ];

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 via-purple-900 to-slate-900">
      {/* Hero Section */}
      <div className="container mx-auto px-4 py-16">
        <div className="text-center mb-16 animate-fade-in">
          <h1 className="text-6xl md:text-7xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-blue-400 via-purple-400 to-pink-400 mb-6">
            Morning Value
          </h1>
          <p className="text-xl md:text-2xl text-gray-300 mb-4">
            Species Fight Management System
          </p>
          <p className="text-lg text-gray-400 max-w-2xl mx-auto">
            Create powerful species, engage in epic battles, and climb the rankings
          </p>
        </div>

        {/* Statistics Cards */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-16">
          <Card className="bg-gradient-to-br from-blue-500/10 to-blue-600/10 border border-blue-500/20 backdrop-blur-sm">
            <div className="text-center">
              {speciesLoading ? (
                <Loading />
              ) : (
                <>
                  <div className="text-5xl font-bold text-blue-400 mb-2">
                    {totalSpecies}
                  </div>
                  <div className="text-gray-300 text-lg font-semibold mb-1">
                    Total Species
                  </div>
                  <div className="text-gray-400 text-sm">
                    Registered fighters
                  </div>
                </>
              )}
            </div>
          </Card>

          <Card className="bg-gradient-to-br from-red-500/10 to-red-600/10 border border-red-500/20 backdrop-blur-sm">
            <div className="text-center">
              {fightsLoading ? (
                <Loading />
              ) : (
                <>
                  <div className="text-5xl font-bold text-red-400 mb-2">
                    {totalFights}
                  </div>
                  <div className="text-gray-300 text-lg font-semibold mb-1">
                    Total Battles
                  </div>
                  <div className="text-gray-400 text-sm">
                    Fights completed
                  </div>
                </>
              )}
            </div>
          </Card>

          <Card className="bg-gradient-to-br from-yellow-500/10 to-yellow-600/10 border border-yellow-500/20 backdrop-blur-sm">
            <div className="text-center">
              {fightsLoading ? (
                <Loading />
              ) : latestFight ? (
                <>
                  <div className="text-2xl font-bold text-yellow-400 mb-2 truncate">
                    {latestFight.winner?.name || 'Unknown'}
                  </div>
                  <div className="text-gray-300 text-lg font-semibold mb-1">
                    Latest Victor
                  </div>
                  <div className="text-gray-400 text-sm">
                    Last battle winner
                  </div>
                </>
              ) : (
                <>
                  <div className="text-3xl mb-2">🎯</div>
                  <div className="text-gray-300 text-lg font-semibold mb-1">
                    No Battles Yet
                  </div>
                  <div className="text-gray-400 text-sm">
                    Start your first fight
                  </div>
                </>
              )}
            </div>
          </Card>
        </div>

        {/* Feature Cards */}
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
          {featureCards.map((feature, index) => (
            <Link
              key={feature.path}
              to={feature.path}
              className="group transform transition-all duration-300 hover:scale-105"
              style={{ animationDelay: `${index * 100}ms` }}
            >
              <Card className="h-full bg-white/5 backdrop-blur-sm border border-white/10 hover:border-white/30 transition-all duration-300">
                <div className="text-center">
                  <div
                    className={`w-20 h-20 mx-auto mb-4 rounded-full bg-gradient-to-br ${feature.color} ${feature.hoverColor} flex items-center justify-center text-4xl transform transition-transform duration-300 group-hover:rotate-12 group-hover:scale-110`}
                  >
                    {feature.icon}
                  </div>
                  <h3 className="text-xl font-bold text-white mb-2 group-hover:text-blue-300 transition-colors">
                    {feature.title}
                  </h3>
                  <p className="text-gray-400 text-sm leading-relaxed">
                    {feature.description}
                  </p>
                </div>
              </Card>
            </Link>
          ))}
        </div>
      </div>
    </div>
  );
};
