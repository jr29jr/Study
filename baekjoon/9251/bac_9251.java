package backjoon;

import java.io.*;
import java.util.*; 

public class bac_9251 {

    public static void main(String[] args) {
        input();
        process(first, second);
    }
    static String first,second;

    static void input(){
        FastReader fr=new FastReader();
        first=fr.nextLine();
        second=fr.nextLine();
    }
    static int MAX_LENGTH=1000;
    static void process(String f,String s){
        int[][] dp=new int[f.length()+1][s.length()+1];

        for(int i=1;i<=f.length();i++){
            for(int j=1;j<=s.length();j++){
                if(f.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i][j],dp[i][j-1]));
                }
            }
        }

        System.out.println(dp[f.length()][s.length()]);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
