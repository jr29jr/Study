package backjoon;

import java.io.*;
import java.util.*; 

public class bac_11729 {

    public static void main(String[] args) {
        input();
        int result=hanoi(size, 1, 2, 3);
        System.out.println(result);
        System.out.println(sb.toString());
    }   
    static int size;
    static StringBuilder sb=new StringBuilder();
    static void input(){
        FastReader fr=new FastReader();
        size=fr.nextInt();
    }
    /**
     * 피보나치마냥 대표적인 재귀 문제였다 ㅋㅋ
     */
    static int hanoi(int n,int from,int mid,int to){
        if(n == 1){
            sb.append(from +" "+ to).append('\n');
            return 1;
        }
        int result=0;
        //n-1을 빈곳으로 보내기
        result+=hanoi(n-1,from,to,mid);
        //시작부터 목적지로 마지막판 이동
        sb.append(from +" "+ to).append('\n');
        result++;
        //중간판에서 목적지로 이동
        result+=hanoi(n-1,mid,from,to);

        return result;
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

