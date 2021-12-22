import java.util.ArrayList;
import java.util.List;

public class ValidPath {
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(i,new ArrayList<>());
        for(int[] ed : edges){
           adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }
        return helper(n,adj,start,end,vis);
    }
   static boolean helper(int n, List<List<Integer>> edges, int s,int e, int[] vis){
        if(s == e)
            return true;
        vis[s] = 1;
        for(int i = 0; i < edges.get(s).size(); i++){
            int newStart = edges.get(s).get(i);
            if(vis[newStart] == 0 && helper(n,edges,newStart,e,vis))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges ={{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        System.out.println(validPath(10,edges,7,5));
    }
}
