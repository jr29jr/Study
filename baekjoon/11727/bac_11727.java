package backjoon;

import java.io.*;
import java.util.*; 

public class bac_11727 {

    public static void main(String[] args) {
        input();
        process(length);
    }
    static int MAX_LENGTH=1000;
    static int length;
    static void input(){
        FastReader fr=new FastReader();
        length=fr.nextInt();
    }

    static void process(int length){
        int[] dp=new int[MAX_LENGTH+1];

        dp[1]=1;
        dp[2]=3;
        for(int i=3;i<=length;i++){
            dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
        }
        System.out.println(dp[length]);
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

