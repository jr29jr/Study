package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1932 {

    public static void main(String[] args) {
        input();
        process(N, numbers);
    }
    
    static int N;//숫자 개수
    static int[][] numbers;//숫자 리스트
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();

        numbers=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                numbers[i][j]=fr.nextInt();
            }
        }
    }

    static void process(int N,int[][] numbers){
        int[][] dp=new int[N][N];
        dp[0][0]=numbers[0][0];
        for(int i=0;i<N-1;i++){
            for(int j=0;j<=i;j++){
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]+numbers[i+1][j]);
                dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i][j]+numbers[i+1][j+1]);
            }
        }

        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(dp[N-1][i],max);
        }
        System.out.println(max);
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

