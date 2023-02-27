package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1904 {

    public static void main(String[] args) {
        input();
        process(N);
    }   
    static int N;
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();

    }
    static int MIN_LENGTH=2;//초기값 세팅을 위한 최소길이
    static void process(int length){
        int[] dp;
        if(length > 2)
            dp=new int[length+1];
        else
            dp=new int[MIN_LENGTH+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=length;i++){
            dp[i]=(dp[i-1]+dp[i-2])%15746;
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

