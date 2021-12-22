import java.util.ArrayList;

public class Boggle {
    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' } };
        String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
        String[] out = wordBoggle(boggle,dictionary);
        for(String s : out)
            System.out.println(s);
    }
    public static String[] wordBoggle(char board[][], String[] dictionary)
    {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                util(i,j,vis,board,"",l,dictionary);
            }
        }
        String[] out = new String[l.size()];
        int i = 0;
        for(String s : l)
            out[i++] = s;
        return out;
    }
    static void util(int i, int j, boolean[][] vis, char[][] b, String s, ArrayList<String> l, String[] dict){
        vis[i][j] = true;
        s = s+b[i][j];
        if(isWord(s,dict)) {
            if(!l.contains(s))
            l.add(s);
        }
        for(int r = i-1; r <= i+1 && r < b.length; r++){
            for(int c = j-1; c <= j+1 && c < b[0].length; c++){
                if(r >= 0 && c >= 0 && !vis[r][c])
                    util(r,c,vis,b,s,l,dict);
            }
        }
        s = s.substring(0,s.length()-1);
        vis[i][j] = false;
    }
    static boolean isWord(String s, String[] dict){
        for(int i = 0; i < dict.length; i++){
            if(dict[i].equals(s))
                return true;
        }
        return false;
    }
}
