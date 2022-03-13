import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int k;
    static int[] S,ans;
    static int[] check;
    static int input() {
        k=scan.nextInt();
        S=new int[k+1];
        check=new int[k+1];
        ans=new int[7];
        for(int i=1;i<=k;i++)
            S[i]=scan.nextInt();
        return k;
    }


    static void rec_func(int v){
        if( v == 7){
            for(int i=1;i<=6;i++){
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
        }
        else{
            for(int i=1;i<=k;i++){
                //사용안한거고 이이전값보다 큰 경우만
                if(check[i] == 0 && ans[v-1] < S[i]){
                    ans[v]=S[i];
                    check[i]=1;
                    rec_func(v+1);
                    ans[v]=0;
                    check[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        while(true){
            if(input() == 0)
                break;
            rec_func(1);
            sb.append('\n');
        }
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
