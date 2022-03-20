import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int[][] Dy;
    static int MAX=40;
    static void input() {

    }


    static void preprocess(){
        Dy=new int[MAX+1][2];
        //초기값
        Dy[0][0]=1;Dy[0][1]=0;//이걸 이상하게 정의했엇다.
        Dy[1][0]=0;Dy[1][1]=1;
        Dy[2][0]=1;Dy[2][1]=1;

        for(int i=3;i<=MAX;i++){
            Dy[i][0]=Dy[i-1][0]+Dy[i-2][0];
            Dy[i][1]=Dy[i-1][1]+Dy[i-2][1];
        }

    }
    static void process(){
        int N=scan.nextInt();
        for(int i=0;i<N;i++){
            int test=scan.nextInt();
            sb.append(Dy[test][0]).append(' ').append(Dy[test][1]).append('\n');
        }
    }
    public static void main(String[] args) {
        preprocess();
        process();
        System.out.print(sb.toString());
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
