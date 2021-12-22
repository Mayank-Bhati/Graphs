import java.util.ArrayList;

public class components {
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
        int[] vis = new int[11];
        int components = 0;
        for (int i = 0; i < 11; i++) {
            if (vis[i] != 1) {
                components++;
//                BFS bfs = new BFS();
//                bfs.BFS(i, vis, adj);
                DFS dfs = new DFS();
                dfs.DFS(i,vis,adj);
            }
        }
        System.out.println();
        System.out.println("components = "+components);
    }
}
