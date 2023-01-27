package backjoon;

import java.io.*;
import java.util.*; 

public class bac_13702 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N,peopleCnt;//주전자수,사람 수
    static int[] bottles;//술병(주전자) 개수
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        peopleCnt=fr.nextInt();

        bottles=new int[N];
        for(int i=0;i<N;i++)
            bottles[i]=fr.nextInt();
    }

    
    static void process(){
        //나눠줄 막걸리 양을 매개변수로 술병이 N개 있을때 모든사람에게 줄 수 있는지 확인하는 이분 탐색
        int start=1,end=Integer.MAX_VALUE;
        long result=binarySearch(start, end,N);
        System.out.println(result);
    }
    /**
     * 주전자에 있는 술을 모든 사람에게 즐 수 있는 최대용량을 구하는 메소드
     * @param start 주전자 최소 용량
     * @param end 주전자 최대 용량
     * @param result 주전자 개수
     * @return 줄 수 있는 최대용량
     */
    static long binarySearch(long start,long end,int result){
        long volumn=start;//최소치는 줄 수 있다.
        while(start <= end){
            long mid=(start+end)/2;
            //나눠줄 수 있으면 용량을 늘리자
            if(canGive(mid,result)){
                volumn=mid;
                start=mid+1;
            }
            //못 나눠주면 용량 줄이자
            else{
                end=mid-1;
            }
        }
        return volumn;
    }
    /**
     * 주전자의 술을 모든 사람에게 줄 수 있는지 확인하는 메소드
     * @param volumn 한사람에게 줄 술의 양
     * @param count 주전자 개수
     * @return
     */
    static boolean canGive(long volumn,int count){
        int sum=0;
        for(int i=0;i<count;i++){
            sum+=bottles[i]/volumn;
        }
        //다 나눠줄 수 있으면
        if(sum >= peopleCnt)
            return true;
        //다 못 나눠주면
        else
            return false;
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

