import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,MAX=300;
    static int[] scores;
    static int[] stairs;
    static void input(){
        N=scan.nextInt();
        scores=new int[N+1];
        stairs=new int[N+1];
        for(int i=1;i<=N;i++)
            stairs[i]=scan.nextInt();
    }
    static void prerpocess(int k){
        if(k>0)
            scores[1]=stairs[1];
        if(k>1)
            scores[2]=stairs[1]+stairs[2];
        if(k>2)
            scores[3]=Math.max(stairs[2]+stairs[3],stairs[1]+stairs[3]);
        //점화식
        for(int i=4;i<=k;i++)
            scores[i]=Math.max(scores[i-3]+stairs[i-1]+stairs[i],scores[i-2]+stairs[i]);

    }

    public static void main(String[] args) {
        input();
        prerpocess(N);
        sb.append(scores[N]);
        System.out.println(sb.toString());
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
