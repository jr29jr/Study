import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,min=Integer.MAX_VALUE;
    static int[] route,check;
    static int[][] costs;

    static void input() {
        N=scan.nextInt();
        route=new int[N+1];
        check=new int[N+1];
        costs=new int[N+1][N+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                costs[i][j]=scan.nextInt();
    }
    //경로 계산
    static int calc(){
        int sum=0;
        //마지막은 전까지
        for(int i=1;i<N;i++){
            if(costs[route[i]][route[i+1]] != 0){
                sum+=costs[route[i]][route[i+1]];
            }
            else{
                //길이 없을 경우
                return -1;
            }
        }
        //마지막은 고려할게 많아서 따로하자.
        //길이 있을 경우
        if(costs[route[N]][route[1]] != 0){
            sum+=costs[route[N]][route[1]];
        }
        //길이 없을 경우
        else{
            //돌아갸아한다.(만약 틀리면 가는길만 있는 경우 고려하자)
            for(int i=1;i<N;i++){
                if(costs[route[i+1]][route[i]] != 0){
                    sum+=costs[route[i+1]][route[i]];
                }
                else{
                    //길이 없을 경우
                    return -1;
                }
            }
        }
        return sum;
    }

    static void rec_func(int k){
        if(k == N+1){
            int result=calc();
            if(result == -1)
                //길이 없다.
                return ;
            else{
                //길이 있다.
                min=Math.min(min,result);
            }
        }
        else{
            for(int i=1;i<=N;i++){
                if(check[i]==0){
                    check[i]=1;
                    route[k]=i;
                    rec_func(k+1);
                    route[k]=0;
                    check[i]=0;
                }
            }

        }

    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(min);
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
