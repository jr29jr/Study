package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2343 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N,M;//영상개수,블루레이개수
    static int[] lectures;//영상의 길이
    static int L;//블루레이 1개의 길이
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();

        lectures=new int[N];
        for(int i=0;i<N;i++)
            lectures[i]=fr.nextInt();
    }

    static void process(){
        //길이를 매개변수로 하는 이분탐색
        //길이는 1~1억이다(영상이 최대 1만개인데 최대 1만분)
        
        //더 최적화를 하면 아래처럼 하면 canSave에서 저장못하는 경우에 대한 처리도 필요없다.
        //start = 최소강의
        //end = 모든 강의의 합
        int start=1,end=100000000;
        int result=binarySearch(start,end ,M);
        System.out.println(result);
    }
    /**
     * 블루레이(result)에 모든 영상을 넣을 수 있는 최소 크기
     * @param start 블루레이 최소 길이
     * @param end 블루레이 최대 길이
     * @param result 블루레이 개수
     * @return 넣을 수 있는 블루레이의 최소 길이
     */
    static int binarySearch(int start,int end,int result){
        int length=-1;//못 넣는 경우
        while(start <= end){
            int mid=(start+end)/2;
            //저장이 가능하면 길이를 줄여보자
            if(canSave(mid,result)){
                length=mid;
                end=mid-1;
            }
            //저장이 불가능하면 길이를 늘리자
            else{
                start=mid+1;
            }
        }
        return length;
    }
    /**
     * 특정 길이의 블루레이에 다 저장이 가능한지 확인하는 함수
     * @param length 블루레이 길이
     * @param count 블루레이 개수
     * @return 저장가능 여부
     */
    static boolean canSave(int length,int count){
        boolean can=true;
        int store=length;//길이만큼 저장가능
        count--;//시작하자마자 1개 사용하니깐
        for(int i=0;i<N;i++){
            //저장자체가 불가능한 경우(영상보다 블루레이 길이가 작을 경우)
            if(length < lectures[i]){
                can=false;
                break;
            }

            //저장공간이 충분하면 저장하자
            if(store >=lectures[i]){
                store-=lectures[i];
            }
            //저장공간이 모자를 경우
            else{
                //다음 블루레이를 가져오자
                //블루레이 개수를 줄이고 저장공간을 초기화
                count--;
                store=length;
                //블루레이가 모자를 경우
                if(count < 0){
                    can=false;
                    break;
                }
                //충분하면 저장하자
                store-=lectures[i];
                
            }
        }
        return can;
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

