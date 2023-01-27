package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1806 {

    public static void main(String[] args) {
        input();
        int result=process();
        System.out.println(result);
    }
    
    static int N,S;//수의 개수,구할 수의 합
    static int[] list;//수 배열
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        S=fr.nextInt();

        list=new int[N];
        for(int i=0;i<N;i++)
            list[i]=fr.nextInt();

    }
    /**
     * 투 포인터로 계산
     * @return
     */
    static int process(){
        int sum=0,min=Integer.MAX_VALUE;
        //start부터 end-1까지 저장
        int end=0;
        for(int start=0;start<N;start++){
            //sum이 S보다 작을경우
            while(sum < S && end <N){
                sum+=list[end];
                end++;
            }
            if(sum >= S){
                min=Math.min(end-start,min);
            }
            sum-=list[start];
        }
        if(min == Integer.MAX_VALUE)
            min=0;

        return min;
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

