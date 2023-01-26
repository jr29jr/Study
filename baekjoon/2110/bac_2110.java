package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2110 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N,C;//집의 개수,공유기 개수
    static int[] houses;//집의 좌표를 저장

    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        C=fr.nextInt();
        
        houses=new int[N];
        for(int i=0;i<N;i++)
            houses[i]=fr.nextInt();
        
    }
    
    static void process(){
        //집의 좌표를 정렬해두자.
        Arrays.sort(houses);
        //공유기 거리를 매개변수로 최대값을 찾는다.
        int result=binarySearch(0, 1000000000, C);
        System.out.println(result);
    }
    /**
     * result(공유기)를 설치 할 수 있는지 확인해서 가능한 최대거리를 반환
     * @param start 시작점
     * @param end 끝점
     * @param result 설치할 공유기 개수
     * @return
     */
    static int binarySearch(int start,int end,int result){
        int location=-1;
        while(start <= end){
            int mid=(start+end)/2;
            //설치가 가능하다
            if(canLocate(mid)){
                location=mid;
                start=mid+1;
            }
            //설치불가능
            else{
                end=mid-1;
            }
        }
        return location;
    }
    /**
     * 특정 거리간격만큼 공유기를 설치 할 수 있냐?
     * @param distance 공유기간의 최소거리
     * @return 가능여부
     */
    static boolean canLocate(int distance){
        int count=C;//공유기가 다 설치됐는지 확인하는 변수
        int x=0;//최근 설치한 공유기 좌표
        //처음위치에 일단 두자.
        x=houses[0];
        count--;
        for(int i=1;i<N;i++){
            //좌표가 현재위치 + 공유기거리 이상이면 공유기 두자
            if(houses[i] >= x+distance){
                x=houses[i];
                count--;
                //공유기 다 놨으면 끝내자
                if(count == 0)
                   break;
            }
            
        }
        if(count == 0)
            return true;
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
