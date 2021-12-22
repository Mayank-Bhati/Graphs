import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartite {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> l0 = new ArrayList<>();
        l0.add(3);
        adj.add(0, l0);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(6);
        adj.add(1, l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(6);
        l2.add(9);
        adj.add(2, l2);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(4);
        adj.add(3, l3);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(3);
        l4.add(5);
        l4.add(9);
        adj.add(4, l4);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(4);
        adj.add(5, l5);
        ArrayList<Integer> l6 = new ArrayList<>();
        l6.add(1);
        l6.add(2);
        l6.add(7);
        adj.add(6, l6);
        ArrayList<Integer> l7 = new ArrayList<>();
        l7.add(6);
        adj.add(7, l7);
        ArrayList<Integer> l8 = new ArrayList<>();
        l8.add(10);
        adj.add(8, l8);
        ArrayList<Integer> l9 = new ArrayList<>();
        l9.add(4);
        l9.add(2);
        adj.add(9, l9);
        ArrayList<Integer> l10 = new ArrayList<>();
        l10.add(8);
        adj.add(10, l10);
        int[] colour = new int[adj.size() + 1];
        Arrays.fill(colour, -1);
        colour[0] = 0;
        boolean done = true;
        for (int i = 0; i < adj.size(); i++) {
            if (colour[i] != -1) {
                if (!bipartiteByDFS(i,adj,colour)) {
                    System.out.println("not Bipartite");
                    done = false;
                    break;
                }
            }
        }
        if (done)
            System.out.println("Bipartite");
    }

    private static boolean bipartiteByDFS(int i, ArrayList<ArrayList<Integer>> adj, int[] colour) {
        for(int x : adj.get(i)){
            if(colour[x] == -1){
                colour[x] = 1-colour[i];
                bipartiteByDFS(x,adj,colour);
            }
            else if(colour[x] == colour[i])
                return false;
        }
        return true;
    }

    private static boolean bipartiteByBFS(int node, ArrayList<ArrayList<Integer>> adj, int[] colour) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int temp = q.poll();
//           if(colour[temp] == -1)
//               colour[temp] = colour[node]-1;
//           else if(colour[temp] == colour[node])
//                   return false;
            for (int x : adj.get(temp)) {
                if (colour[x] == -1) {
                    q.add(x);
                    colour[x] = 1 - colour[temp];
                } else if (colour[x] == colour[temp])
                    return false;
            }
        }
        return true;
    }

}
