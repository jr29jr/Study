import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int MAX=20;
    static int[] Dy;
    static void input() {

    }

    static void preprocess(){
        Dy=new int[MAX+1];
        //초기값
        Dy[0]=0;
        Dy[1]=1;
        Dy[2]=1;
        for(int i=3;i<=MAX;i++)
            Dy[i]=Dy[i-1]+Dy[i-2];
    }

    static void process(){
        int n=scan.nextInt();
        sb.append(Dy[n]);
    }
    public static void main(String[] args) {
        preprocess();
        process();
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
