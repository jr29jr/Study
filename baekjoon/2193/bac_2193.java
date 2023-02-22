package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2193 {

    public static void main(String[] args) {
        input();
        process(numberSize);
    }
    
    static int numberSize;
    static void input(){
        FastReader fr=new FastReader();
        numberSize=fr.nextInt();
    }

    static int MAX_SIZE=90;
    static void process(int numberSize){
        long[][] dp=new long[numberSize+1][2];//끝자리가 0과 1일때 개수 저장
        
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<=numberSize;i++){
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
            dp[i][1]=dp[i-1][0];
        }

        long result=dp[numberSize][0]+dp[numberSize][1];
        System.out.println(result);
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

