package backjoon;

import java.io.*;
import java.util.*;

public class bac_11399 {

    public static void main(String[] args) {
        input();
        System.out.println(process());
    }
    
    static int peopleCount;//사람수
    static int[] times;//사람들의 소요시간 배열
    /**
     * 사람수와 그 사람들의 소요시간을 입력받는다.
     */
    static void input(){
        FastReader fr=new FastReader();
        peopleCount=fr.nextInt();

        times=new int[peopleCount];
        for(int i=0;i<peopleCount;i++)
            times[i]=fr.nextInt();
    }
    /**
     * 정렬후 총 소요시간을 계산
     */
    static int process(){
        //소요시간을 오름차순으로 정렬하자.
        Arrays.sort(times);
        //대기시간,모든 사람의 소요시간의 합
        int waitTime=0,totalTime=0;
        //소요시간을 계산
        for(int i=0;i<peopleCount;i++){
            //사람의 소요시간과 대기시간을 더하면 된다.
            totalTime+=times[i]+waitTime;
            //대기시간은 앞사람의 소요시간만큼 늘어간다.
            waitTime+=times[i];
        }
        return totalTime;
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
