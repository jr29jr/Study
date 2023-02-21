package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2156 {

    public static void main(String[] args) {
        input();
        process(glassCount, glasses);
    }
    static int glassCount;
    static int[] glasses;
    static int MAX_COUNT=10000;
    public static void input(){
        FastReader fr=new FastReader();
        glassCount=fr.nextInt();

        glasses=new int[MAX_COUNT];
        for(int i=0;i<glassCount;i++)
            glasses[i]=fr.nextInt();
    }

    static void process(int glassCount,int[] glasses){
        int[] dp=new int[glassCount];        

        dp[0]=glasses[0];

        if(glassCount >= 2)
            dp[1]=glasses[1]+dp[0];

        if(glassCount >= 3)
            dp[2]=Math.max(dp[1],Math.max(glasses[0]+glasses[2],glasses[1]+glasses[2]));
        
        for(int i=3;i<glassCount;i++){
            dp[i]=Math.max(dp[i-1],Math.max(glasses[i-1]+dp[i-3],dp[i-2])+glasses[i]);
        }

        System.out.println(calcMax(dp));
    }
    static int calcMax(int[] list){
        int max=0;
        for(int i=0;i<list.length;i++)
            max=Math.max(max,list[i]);
        return max;
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

