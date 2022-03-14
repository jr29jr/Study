import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,M;
    static int[] numbers,ans;

    static void input() {
        N=scan.nextInt();
        M=scan.nextInt();
        numbers=new int[N+1];
        ans=new int[M+1];
        for(int i=1;i<=N;i++)
            numbers[i]=scan.nextInt();
        Arrays.sort(numbers);
    }


    static void rec_func(int k){
        if(k == M+1){
            //sb에 넣자
            for(int i=1;i<=M;i++)
                sb.append(ans[i]).append(' ');
            sb.append('\n');
        }
        else{
            int lastUse=0;
            for(int i=1;i<=N;i++){
                ans[k]=numbers[i];
                lastUse=numbers[i];
                rec_func(k+1);
                ans[k]=0;
            }
        }
    }
    public static void main(String[] args) {
        input();
        rec_func(1);
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
