package backjoon;

import java.io.*;
import java.util.*; 

public class bac_10844 {

    public static void main(String[] args) {
        input();
        process(N);
    }
    
    static int N;
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
    }
    static int MAX_DIGIT=100;
    static void process(int digit){
        int[][] dp =new int[MAX_DIGIT+1][10];
        //처음 세팅
        for(int i=1;i<=9;i++){
            dp[1][i]=1;
        }

        //dp 채우기
        for(int i=2;i<=digit;i++){
            for(int j=0;j<10;j++){              
                //0의 경우
                if(j==0)
                    dp[i][j]=dp[i-1][j+1];
                //1~8의 경우
                else if(0 < j && j< 9)
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                else
                    dp[i][j]=dp[i-1][j-1];
            }
        }

        //print result
        long result=0;
        for(int i=0;i<=9;i++)
            result+=dp[digit][i];
        System.out.println(result%1000000000);
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
