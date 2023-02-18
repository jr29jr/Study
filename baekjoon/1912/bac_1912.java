package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1912 {

    public static void main(String[] args) {
        input();
        int result=process(numberCount, numbers);
        System.out.println(result);
    }
    
    static int numberCount;
    static int[] numbers;

    static void input(){
        FastReader fr=new FastReader();
        numberCount=fr.nextInt();

        numbers=new int[numberCount];

        for(int i=0;i<numberCount;i++)
            numbers[i]=fr.nextInt();
    }

    static int process(int numberCount,int[] numbers){
        int[] dp=new int[numberCount];
        dp[0]=numbers[0];
        int result=dp[0];
        
        for(int i=1;i<numberCount;i++){
            dp[i]=Math.max(numbers[i],dp[i-1]+numbers[i]);
            result=Math.max(dp[i],result);
        }

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
