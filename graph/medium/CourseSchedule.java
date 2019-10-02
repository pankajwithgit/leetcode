/*
https://leetcode.com/problems/course-schedule/
This is a case of topological sort (https://en.wikipedia.org/wiki/Topological_sorting)

*/
class Solution {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; 
        
        // Index of this list is a course and its values are the dependencies (children)
        List<List<Integer>> courseDependency = new ArrayList<>(numCourses);
        
        for (int i = 0; i < numCourses; i++)
            courseDependency.add(new ArrayList<>());
        
        /*
        create following courseDependency arraylist for each index (course)
            0: [1,2],
            1: [2],
            2: []
        */
        for (int i = 0; i < prerequisites.length; i++) {
            courseDependency.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // use state int array to represent current status of visiting for each node
		// 0: not visited yet, 1: currently visiting (in recursion stack frame), 2: already visited
        int[] state = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courseDependency, state)) {
                return false;   // Cycle found
            }
        }
        
        // no cycle found
        return true;
    }
    
    private boolean dfs(int course, List<List<Integer>> courseDependency, int[] state) {
        state[course] = 1;  // currently visiting
        
        List<Integer> dependencies = courseDependency.get(course);
        
        for (int children: dependencies) {
            if (state[children] == 1)   // If any children is also being currently visiting, then cycle is detected
                return false;
            
            if (state[children] == 0) { // Not visted yet
                if (!dfs(children, courseDependency, state))
                    return false;
            }
        }
        
        state[course] = 2;  // done visiting
        return true;        // no cycle, backtrack to caller
    }
}
