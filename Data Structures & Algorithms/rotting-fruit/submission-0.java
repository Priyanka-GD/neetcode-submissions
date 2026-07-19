class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    freshOranges++;
                }else if(grid[row][col] == 2){
                    queue.add(new int[]{row, col, 0});
                }
            }
        }
        int timeElapsed = 0, freshToRottenCount = 0;

        while(!queue.isEmpty()){
            int currEle[] = queue.poll();
            int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

            for(int dir[] : dirs){
                int currRow = dir[0] + currEle[0];
                int currCol = dir[1] + currEle[1];
                int time = currEle[2];
                timeElapsed = Math.max(timeElapsed, time);

                if(currRow >= rows || currRow < 0 || currCol >= cols || currCol < 0 ||
                grid[currRow][currCol] != 1){
                    continue;
                }

                grid[currRow][currCol] = 2;
                freshToRottenCount++;
                queue.add(new int[]{currRow, currCol, time + 1});
            }
        }
        return freshToRottenCount == freshOranges? timeElapsed : -1;
    }


}
