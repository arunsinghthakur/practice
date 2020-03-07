package joker.ds.tree;

import joker.ds.queue.RottonOrange;

public class NumOfIsland {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i-1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j-1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(grid, i+1, j);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            dfs(grid, i, j+1);
        }
    }
}
