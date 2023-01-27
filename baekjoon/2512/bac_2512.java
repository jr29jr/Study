package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2512 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int N,total ;//지방의 수,국가 총예산액
    static int[] cities;//도시별 요청금액 리스트
    static int max=0;//요구 예산의 최대치
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        
        cities=new int[N];
        for(int i=0;i<N;i++){
            cities[i]=fr.nextInt();
            max=Math.max(cities[i],max);
        }
        
        total=fr.nextInt();
    }
    static void process(){
        //요구치 다 제공가능한지 확인
        if(canGive()){
            System.out.println(max);
        }
        //안되면 상한선을 정하는 이분탐색
        else{
            int result=binarySearch(1, max, total);
            System.out.println(result);
        }
    }
    /**
     * 총액(result)을 넘지않는 상한액을 구하는 이분탐색 메소드
     * @param start 최소 금액
     * @param end 최대 금액
     * @param result 정부 총액
     * @return 상한액의 최대치
     */
    static int binarySearch(int start,int end,int result){
        int max=1;
        while(start <= end){
            int mid=(start+end)/2;
            //상한액이 가능한 경우 올려보자.
            if(canGive(mid)){
                max=mid;
                start=mid+1;
            }
            //상한액이 불가능하면 줄이자
            else{
                end=mid-1;
            }
        }
        return max;
    }
    /**
     * 요구한 예산치만큼 전부 제공가능한지 확인하는 메소드
     * @return 요구된 예산의 최대치
     */
    static boolean canGive(){
        boolean can=false;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=cities[i];
        }
        if(sum <= total)
            can=true;
        return can;
    }
    /**
     * 상한액(max)일때 지급 가능여부
     * @param max
     * @return
     */
    static boolean canGive(int max){
        boolean can=false;
        int sum=0;
        for(int i=0;i<N;i++){
            if(cities[i] > max){
                sum+=max;
            }
            else{
                sum+=cities[i];
            }
        }
        //총액보다 작을경우 지급가능
        if(sum <=total)
            can=true;
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
