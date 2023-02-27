package backjoon;

import java.io.*;
import java.util.*; 

public class bac_9465 {

    public static void main(String[] args) {
        input();
        proces(N);
    }
    static FastReader fr=new FastReader();
    static int N;
    static void input(){
        N=fr.nextInt();
    }

    static void proces(int testCase){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<testCase;i++){
            int colLength=fr.nextInt();
            int[][] stickerList=new int[2][colLength];
                 
            for(int row=0;row<2;row++){
                StringTokenizer st=new StringTokenizer(fr.nextLine());
                for(int col=0;col<colLength;col++){                    
                    stickerList[row][col]=Integer.parseInt(st.nextToken());
                }
            }
            sb.append(calcScore(stickerList, colLength)).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int calcScore(int[][] stickerList,int colLength){
        int result=0;
        int[][] dp=new int[2][colLength];
        dp[0][0]=stickerList[0][0];
        dp[1][0]=stickerList[1][0];
        
        if(colLength > 1){
            dp[0][1]=stickerList[0][1]+dp[1][0];
            dp[1][1]=stickerList[1][1]+dp[0][0];    
        }

        for(int i=2;i<colLength;i++){
            dp[0][i]=Math.max(dp[1][i-1],Math.max(dp[1][i-2],dp[0][i-2]))+stickerList[0][i];
            dp[1][i]=Math.max(dp[0][i-1],Math.max(dp[1][i-2],dp[0][i-2]))+stickerList[1][i];
        }
        result=Math.max(dp[0][colLength-1],dp[1][colLength-1]);
        return result;
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
