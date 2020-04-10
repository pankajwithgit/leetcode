/**Insert short person to tall person will not affect the relative order of the taller persons, thus sort from higher height to lower heigh
 * for persons with same height, sort them according to the k index
 * for example: for [7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
 * first sort tallest persons [7,0], [7,1],
 * then insert lower height to the position of their k index
 * [7,0], [6,1] [7,1]
 * [5,0],[7,0], [6,1] [7,1]
 * [5,0],[7,0], [5,2] [6,1] [7,1]
 * [5,0],[7,0], [5,2] [6,1], [4,4] [7,1]
 * done.
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                return (person1[0] == person2[0]) ? person1[1] - person2[1] : person2[0] - person1[0];
            }
        });
        List<int[]> list = new LinkedList<int[]>();
        for (int[] cur : people) {
            list.add(cur[1], cur); // list.add will append the element at specified index, by shifting other elements to right.
        }
        return list.toArray(new int[people.length][2]);
    }
}
