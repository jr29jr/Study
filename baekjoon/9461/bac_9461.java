package backjoon;

import java.io.*;
import java.util.*; 


public class bac_9461 {

    public static void main(String[] args) {
        input();
        process(testCase);
    }
    static FastReader fr=new FastReader();
    static int testCase;
    static void input(){
        testCase=fr.nextInt();
    }

    static int MAX_SIZE=100;
    /**
     * 값의 범위가 int 벗어날걸 예측했어야했다.
     * @param testCase
     */
    static void process(int testCase){
        //미리 100개 다 만들고 그냥 리턴해주자.
        long[] dp=new long[MAX_SIZE];
        //초기값 설정
        dpSetting(dp);

        for(int i=8;i<MAX_SIZE;i++){
            dp[i]=dp[i-1]+dp[i-5];
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<testCase;i++){
            int nowIndex=fr.nextInt();
            sb.append(dp[nowIndex-1]).append('\n');
        }

        System.out.println(sb.toString());
    }
    static void dpSetting(long[] dp){
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=2;
        dp[5]=3;
        dp[6]=4;
        dp[7]=5;
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

