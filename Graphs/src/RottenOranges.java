import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, total = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i,j));
                    total++;
                }
                else if(grid[i][j] == 1)
                    total++;
            }
        }
        int[][] dir = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };
        int ans = 0;
        while(q.size() < total){
            ans++;
            int size = q.size();
            boolean change = false;
            for(int i = 0; i < size; i++){
                pair p = q.poll();
                int r = p.x;
                int c = p.y;
                for(int j = 0; j < 4; j++){
                    int newR = r+dir[j][0], newC = c + dir[j][1];
                    if(newR >= 0 && newC >= 0 && newR < m && newC < n){
                        if(grid[newR][newC] == 1){
                            grid[newR][newC] = 2;
                            q.add(new pair(newR,newC));
                            change = true;
                        }
                    }
                }
                q.add(p);
            }
            if(!change)
                return -1;
        }
        return ans;
    }
}
class pair{
    int x, y;
    pair(int i, int j){
        x = i;
        y = j;
    }
}
