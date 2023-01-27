package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2003 {

    public static void main(String[] args) {
        input();
        System.out.println(process());
    }
    static int N,S;//숫자 개수,구해야할 합
    static int[] list;//수자 배열
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        S=fr.nextInt();

        list=new int[N];
        for(int i=0;i<N;i++)
            list[i]=fr.nextInt();
    }

    static int process(){
        int end=0;//end-1까지 저장
        int sum=0,count=0;
        for(int start =0;start<N;start++){
            while( sum < S  && end < N){
                sum+=list[end];
                end++;
            }
            //같은지 확인
            if( sum == S){
                count++;
            }
            //앞에부터 제거하자
            sum-=list[start];
        }
        return count;
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
