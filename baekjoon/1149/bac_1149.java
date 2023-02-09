package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1149 {

    public static void main(String[] args) {
        input();
        process();
        
    }
    
    static int houseCount;//집개수
    static int COLOR_COUNT=3;
    static int[][] colorCost;//index번째 집 색칠비용(빨.초,파 순으로)
    
    static void input(){
        FastReader fr=new FastReader();
        houseCount=fr.nextInt();

        colorCost=new int[houseCount][COLOR_COUNT];
        for(int i=0;i<houseCount;i++){
            for(int j=0;j<COLOR_COUNT;j++)
                colorCost[i][j]=fr.nextInt();
        }
    }
    static int[][] dp;//i번째 집을 j색으로 칠하는 최소비용
    static void process(){
        dp=new int[houseCount][COLOR_COUNT];
        for(int i=0;i<COLOR_COUNT;i++){
            dp[0][i]=colorCost[0][i];
        }
        for(int i=1;i<houseCount;i++){
            for(int j=0;j<COLOR_COUNT;j++){
                fillArray(i, j);
            }
        }
        int min=Math.min(Math.min(dp[houseCount-1][0],dp[houseCount-1][1]),dp[houseCount-1][2]);
        System.out.println(min);
    }
    /**
     * dp array를 채우자.
     */
    static int fillArray(int index,int color){
        int[][] goColor={{1,2},{2,0},{0,1}};//확인해야할 색깔배열
        
        if(dp[index][color] != 0)
            return dp[index][color];
        
        dp[index][color]=Math.min(fillArray(index-1, goColor[color][0]),fillArray(index-1, goColor[color][1]))+colorCost[index][color];
        /* 
        for(int i=0;i<ColorCount;i++){            
            dp[index][i]=Math.min(fillArray(index-1, goColor[i][0]),fillArray(index-1, goColor[i][1]))+colorCost[index][i];
        }
        */
        return dp[index][color];
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
