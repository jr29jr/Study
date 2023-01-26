package backjoon;

import java.io.*;
import java.util.*; 

public class bac_10816 {

    public static void main(String[] args) {
        input();
        process();
    }
    static FastReader fr=new FastReader();
    static int N,M;//배열의 크기
    static int[] nlist,mlist,count;//n,m배열,m의 값이 n에 몇개있나 저장
    static void input(){
        N=fr.nextInt();
        nlist=new int[N];
        for(int i=0;i<N;i++)
            nlist[i]=fr.nextInt();
        
        M=fr.nextInt();
        count=new int[M];
    }

    static void process(){
        //n리스트 정렬
        Arrays.sort(nlist);
        //M의 숫자들의 개수를 저장
        StringBuilder sb=new StringBuilder();
        //m리스트가 n리스트에 있나 이분탐색으로 확인해서 count배열에 저장
        for(int i=0;i<M;i++){
            int temp=fr.nextInt();
            //이분 탐색결과 값보다 작은 값중 제일큰 방의 index 반환
            int start=searchStart(0, N-1,temp, nlist);
            int end=searchEnd(0, N-1,temp, nlist);
            //같은 값이 몇개인지 찾는다.
            int sum=end-start;
            sb.append(end-start).append(' ');
        }
        System.out.println(sb.toString());
    }
    //result이하중 제일 큰것
    static int searchEnd(int start,int end,int result,int[] array){
        int index=-1;//없을경우 -1 반환
        while(start <= end){
            int mid=(start+end)/2;
            if(array[mid] <= result){
                index=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
    }
    /**
     * array에서 result보다 작은 가장큰 값의 index를 찾는 메소드
     * @param start 시작점
     * @param end 끝점
     * @param result 찾을 값
     * @param array 검색할 배열
     * @return 작은것중 가장큰 값의 index
     */
    static int searchStart(int start,int end,int result,int[] array){
        //result보다 작은값중 오른쪽
        int index =-1;
        while(start <= end){
            int mid=(start+end)/2;
            if(array[mid] < result){
                index=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
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
