import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    /*
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from
 the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
 of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same
  color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
     */
    public static void main(String[] args) {
        int[][] nums = {{1,1,1},
                {1,1,0}};
        int[][] out = floodFill(nums,1,1,2);
        for(int[] arr : out){
            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newC) {
        int rLen = image[0].length, cLen = image.length;
        int[][] out = new int[cLen][rLen];
        for(int i = 0; i < cLen; i++){
            for(int j = 0; j < rLen; j++){
                out[i][j] = image[i][j];
            }
        }
        int[][] vis = new int[cLen][rLen];
        Queue<Point> q = new LinkedList<>();
        Point p =new Point(sr,sc);
        q.add(p);
        while(!q.isEmpty()){
            Point temp = q.poll();
            int r = temp.x;
            int c = temp.y;
            if(vis[r][c] == 1)
                continue;
            else
                vis[r][c] = 1;
            int color = image[r][c];
            out[r][c] = newC;
            if(r+1 < cLen && (image[r+1][c] == color && vis[r+1][c] == 0)){
                out[r+1][c] = newC;
                Point p2 = new Point(r+1,c);
                q.add(p2);
            }
            if(r-1 >= 0 && image[r-1][c] == color && vis[r-1][c] == 0){
                out[r-1][c] = newC;
                Point p2 = new Point(r-1,c);
                q.add(p2);
            }
            if(c+1 < rLen && image[r][c+1] == color && vis[r][c+1] == 0){
                out[r][c+1] = newC;
                Point p2 = new Point(r,c+1);
                q.add(p2);
            }
            if(c-1 >= 0 && image[r][c-1] == color && vis[r][c-1] == 0){
                out[r][c-1] = newC;
                Point p2 = new Point(r,c-1);
                q.add(p2);
            }
        }
        return out;
    }
}
class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
