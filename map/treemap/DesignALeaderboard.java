class Leaderboard {
    Map<Integer, Set<Integer>> sortedScores; // to keep list of players against a score. This will help in finding top k scores.
    Map<Integer, Integer> playersMap; // to map players with their current scores. Will help to update scores quickly. 
    
    public Leaderboard() {
        sortedScores = new TreeMap<>((k1,k2) -> k2 - k1);
        playersMap = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(playersMap.containsKey(playerId)) {
            Integer currScore = playersMap.get(playerId);
            Integer newScore = currScore + score;
            playersMap.put(playerId, newScore);    
            
            sortedScores.get(currScore).remove(playerId);
            if(sortedScores.containsKey(newScore)) {
                sortedScores.get(newScore).add(playerId);
            } else {
                Set<Integer> players = new HashSet<>();
                players.add(playerId);
                sortedScores.put(newScore, players);
            }
        } else {
            playersMap.put(playerId, score);
    
            if(sortedScores.containsKey(score)) {
                sortedScores.get(score).add(playerId);
            } else {
                Set<Integer> players = new HashSet<>();
                players.add(playerId);
                sortedScores.put(score, players);
            }
        }
    }
    
    public int top(int K) {
        Integer output = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : sortedScores.entrySet()) {
            for(Integer playerId : entry.getValue()) {
                output += entry.getKey();
                K--;
                if(K == 0) return output;
            }
        }
        return output;
    }
    
    public void reset(int playerId) {
        Integer score = playersMap.get(playerId);
        playersMap.put(playerId, 0);
        sortedScores.get(score).remove(playerId);
        if(sortedScores.containsKey(0)) {
            sortedScores.get(0).add(playerId);
        } else {
            Set<Integer> players = new HashSet<>();
            players.add(playerId);
            sortedScores.put(0, players);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
