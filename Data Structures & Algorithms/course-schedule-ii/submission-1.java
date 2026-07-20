class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjListForCourses = new ArrayList<>();

        for(int course = 0; course < numCourses; course++){
            adjListForCourses.add(new ArrayList<>());
        }

        int[] dependencyCount = new int[numCourses];

        for(int prerequisite[] : prerequisites){
            adjListForCourses.get(prerequisite[1]).add(prerequisite[0]);
            dependencyCount[prerequisite[0]]++;
        }

        Queue<Integer> coursesTaken = new LinkedList<>();
        for(int course = 0; course < numCourses; course++){
            if(dependencyCount[course] == 0){
                coursesTaken.add(course);
            }
        }
        int[] result = new int[numCourses];

        if(coursesTaken.size() == 0){
            return new int[0];
        }

        int idx = 0;

        while(!coursesTaken.isEmpty()){
            int currCourse = coursesTaken.poll();
            result[idx++] = currCourse;
            for(int nextCourse : adjListForCourses.get(currCourse)){
                dependencyCount[nextCourse]--;
                if(dependencyCount[nextCourse] == 0){
                    coursesTaken.add(nextCourse);
                }
            }
        }
        return idx == numCourses ? result : new int[0];
    }
}
/*
Time Complexity: $O(V + E)$, where $V$ is numCourses and $E$ is the number of prerequisites. 
We visit every course (vertex) and traverse every prerequisite edge once.
 
Space Complexity: $O(V + E)$ to store the adjacency list graph representation 
and the in-degree array.
*/
