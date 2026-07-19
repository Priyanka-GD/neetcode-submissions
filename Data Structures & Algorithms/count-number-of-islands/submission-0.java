class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    numberOfIslands++;
                    dfs(row, col, grid);
                }
            }
        }
        return numberOfIslands;
    }

    public void dfs(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '2';
        dfs(row , col - 1, grid);
        dfs(row - 1, col, grid);
        dfs(row , col + 1, grid);
        dfs(row + 1, col, grid);
        return;
    }

}