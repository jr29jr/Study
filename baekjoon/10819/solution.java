import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int max=Integer.MIN_VALUE;
    static int N;
    static int[] array,ans,check;
    static void input() {
        N=scan.nextInt();
        array=new int[N+1];
        ans=new int[N+1];
        check=new int[N+1];
        for(int i=1;i<=N;i++){
            array[i]=scan.nextInt();
        }
    }

    static int calc(){
        int sum=0;
        for(int i=2;i<=N;i++){
            sum+=Math.abs(ans[i-1]-ans[i]);
        }
        return sum;
    }

    static void rec_func(int v){
        if(v == N+1){
            //수식 계산하고 min과 비교
            int value=calc();
            max=Math.max(max,value);
        }
        else{
            for(int i=1;i<=N;i++){
                if(check[i] == 0){
                    check[i]=1;
                    ans[v]=array[i];
                    rec_func(v+1);
                    ans[v]=0;
                    check[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(max);
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
