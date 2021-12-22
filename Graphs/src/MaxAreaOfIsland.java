import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    /*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
     connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
      are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
     */
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIslandRec(grid));
    }

    public static int maxAreaOfIslandRec(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans = Math.max(ans,area(i,j,grid,vis));
            }
        }
        return ans;
    }

    private static int area(int i, int j, int[][] grid, int[][] vis) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || vis[i][j] == 1)
            return 0;
        else {
            vis[i][j] = 1;
            return (1 + area(i + 1, j,grid,vis)+area(i-1,j,grid,vis)+area(i,j+1,grid,vis)+area(i,j-1,grid,vis));
        }
    }


//    public static int maxAreaOfIsland(int[][] grid) {
//        int m = grid.length, n = grid[0].length, ans = 0;
//        int[][] vis = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 0 || vis[i][j] == 1)
//                    continue;
//                else {
//                    int c = 0;
//                    Queue<point> q = new LinkedList<>();
//                    point p = new point(i, j);
//                    q.add(p);
//                    while (!q.isEmpty()) {
//                        point temp = q.poll();
//                        int x = temp.x;
//                        int y = temp.y;
//                        if (grid[x][y] == 0 || vis[x][y] == 1)
//                            continue;
//                        else
//                            vis[x][y] = 1;
//                        c++;
//                        if (x + 1 < m && grid[x + 1][y] == 1 && vis[x + 1][y] == 0) {
//                            q.add(new point(x + 1, y));
//                        }
//                        if (x - 1 >= 0 && grid[x - 1][y] == 1 && vis[x - 1][y] == 0) {
//                            q.add(new point(x - 1, y));
//                        }
//                        if (y + 1 < n && grid[x][y + 1] == 1 && vis[x][y + 1] == 0) {
//                            q.add(new point(x, y + 1));
//                        }
//                        if (y - 1 >= 0 && grid[x][y - 1] == 1 && vis[x][y - 1] == 0) {
//                            q.add(new point(x, y - 1));
//                        }
//                    }
//                    if (c > ans)
//                        ans = c;
//                }
//            }
//        }
//        return ans;
//    }
//
//    static class point {
//        int x, y;
//
//        point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
