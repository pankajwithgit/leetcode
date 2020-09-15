/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); 

More Details:
https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        
        //First find the potential celebrity candidate
        for(int i = 0; i < n; i++) {
            if(knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        
        // now check if that's infact a celebrity
        for(int i = 0; i < n; i++) {
            if(i == celebrityCandidate) continue;
            
            if(!knows(i, celebrityCandidate)) return -1; 
            
            if(i < celebrityCandidate && knows(celebrityCandidate, i)) return -1;            
        }
        return celebrityCandidate;
    }
}
