import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int N_MAX=5000;
    static int[] mins;//index 무게일때의 최소 횟수
    static void input() {
        N=scan.nextInt();
        mins=new int[N_MAX+1];
    }

    //5000까지 다하자?
    static void solve(int num){
        //5까진 초기화하자.
        mins[3]=1;
        mins[5]=1;
        if(num <= 5){
            return ;
        }
        for(int i=6;i<=num;i++){
           //5,3 나눠서 넣는 과정처리
           int sum5=0,sum3=0;
           //3이 가능한 경우
           if(mins[i-3] != 0){
               sum3=1+mins[i-3];
           }
           //5가 가능한 경우
           if(mins[i-5] != 0){
               sum5=1+mins[i-5];
           }
           //3은 불가능 5는 가능
           if(sum3 == 0 && sum5 != 0){
               mins[i]=sum5;
           }
           //3만 가능
           else if(sum3 != 0 && sum5 == 0){
               mins[i]=sum3;
           }
           //둘다 불가능
           else if(sum3 == 0 && sum5 == 0){
               mins[i]=0;
           }
           //둘다 가능
           else{
               mins[i]=Math.min(sum5,sum3);
           }
        }
    }
    public static void main(String[] args) {
        input();
        solve(N);
        if(mins[N] == 0)
            System.out.println(-1);
        else
            System.out.println(mins[N]);
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
