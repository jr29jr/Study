package backjoon;

import java.io.*;
import java.util.*; 

public class bac_11726 {

    public static void main(String[] args) {
        input();
        process(length);
    }
    static int length;
    static void input(){
        FastReader fr=new FastReader();
        length=fr.nextInt();
    }

    static void process(int length){
        int size=1000;
        int[] fills=new int[size+1];//채우는 가지수 저장
        
        fills[1]=1;
        fills[2]=2;
        fills[3]=3;
        for(int i=4;i<=size;i++){
            fills[i]=(fills[i-1]+fills[i-2])%10007;
        }
        System.out.println(fills[length]);
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

