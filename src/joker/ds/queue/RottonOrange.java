package joker.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottonOrange {

    class Location {
        int i;
        int j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int count = 0;
        Queue<Location> queue = init(grid);

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int i = location.i;
            int j = location.j;
            //System.out.println(i + "@" + j);
            if (i == -1 && j == -1) {
                if (!queue.isEmpty()) {
                    queue.add(new Location(-1, -1));
                    ++count;
                    continue;
                } else {
                    break;
                }

            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                queue.add(new Location(i - 1, j));
                grid[i - 1][j] = 2;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                queue.add(new Location(i, j - 1));
                grid[i][j - 1] = 2;
            }
            if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                queue.add(new Location(i + 1, j));
                grid[i + 1][j] = 2;
            }
            if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                queue.add(new Location(i, j + 1));
                grid[i][j + 1] = 2;
            }
        }
        return allRotton(grid) ? count : -1;
    }

    Queue<Location> init(int[][] grid) {
        Queue<Location> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Location(i, j));
                }
            }
        }
        q.add(new Location(-1, -1));
        return q;
    }

    boolean allRotton(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RottonOrange r = new RottonOrange();
        //int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        //int[][] grid={{0,2}};
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(r.orangesRotting(grid));
    }
}
