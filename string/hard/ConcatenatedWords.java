/*
DP solution. More details:
a) https://leetcode.com/problems/concatenated-words/discuss/348972/Java-Common-template-Word-Break-I-Word-Break-II-Concatenated-Words
b) https://www.youtube.com/watch?v=hLQYQ4zj0qg
*/
class Solution {	 
public List<String> findAllConcatenatedWordsInADict(String[] words) {

 //sort the array in asc order of word length, since longer words are formed by shorter words.
 Arrays.sort(words, (a,b) -> a.length() - b.length());
 
 List<String> result = new ArrayList<>();
 
 //list of shorter words 
 HashSet<String> preWords = new HashSet<>();
 
 for(int i=0; i< words.length; i++){
     //Word Break-I problem.
     if(wordBreak(words[i], preWords)) result.add(words[i]);
     preWords.add(words[i]);
 }
 return result;
}

private boolean wordBreak(String s, HashSet<String> preWords){
 if(preWords.isEmpty()) return false;
 
 boolean[] dp = new boolean[s.length() + 1];
 dp[0] = true;
 
 for(int i = 1; i <= s.length(); i++){
     for(int j = 0; j < i; j++){
         if(dp[j] && preWords.contains(s.substring(j, i))){
             dp[i] = true;
             break;
         }
     }
 }
 return dp[s.length()];
}
}
