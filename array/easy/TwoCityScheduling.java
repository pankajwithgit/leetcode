// We first have to find out delta of cost between both cities for each person and sort decending by delta. This will ensure that we prefer 
// the cases that have maximum saving.
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Base cases
        if(costs == null) return 0;
        if(costs[0].length == 0) return 0;
        
        // Sort array in Decending order of delta for tickets costs for each person.
        Arrays.sort(costs, (a,b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        
        int result = 0;
        int countA = 0;
        int countB = 0;
        
        // Each city will have n people.
        int n = costs.length / 2;
        
        for(int i = 0; i < costs.length; i++) {
            // When both cities are not yet filed.
            if(countA < n && countB < n) {
                // If city A as lowest cost, prefer A.
                if(costs[i][0] < costs[i][1]) {
                    countA++;
                    result += costs[i][0];
                } else { // prefer B
                    countB++;
                    result += costs[i][1];
                }
            } else if(countA < n) { // if City B is full, we have no option except to go to city A.
                countA++;
                result += costs[i][0];
            } else { // if City A is full, we have no option except to go to city B.
                countB++;
                result += costs[i][1];
            }
        }
        return result;
    }
}
