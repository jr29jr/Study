import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int MAX=1000000;
    static long[] Dy,result;//int 초과가능하다.
    static void input() {

    }

    static void preprocess(){
        Dy=new long[MAX+1];
        //초기값
        Dy[1]=1;
        Dy[2]=2;
        Dy[3]=4;
        for(int i=4;i<=MAX;i++)
            Dy[i]=(Dy[i-1]+Dy[i-2]+Dy[i-3])%1000000009;

        result=new long[MAX+1];
        result[1]=1;
        result[2]=2;
        result[3]=2;
        result[4]=3;
        for(int i=5;i<=MAX;i++){
            if(i%2 == 0){
                result[i]+=Dy[i/2];
            }
            if((i-1)%2 == 0){
                result[i]+=Dy[(i-1)/2];
            }
            if((i-2)%2 == 0){
                result[i]+=Dy[(i-2)/2];
            }
            if((i-3)%2 == 0){
                result[i]+=Dy[(i-3)/2];
            }
            result[i]%=1000000009;
        }
    }

    static void process(){
        int n=scan.nextInt();
        for(int i=1;i<=n;i++){
            int t=scan.nextInt();
            sb.append(result[t]).append('\n');
        }
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
