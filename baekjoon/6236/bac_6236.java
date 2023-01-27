package backjoon;

import java.io.*;
import java.util.*; 

public class bac_6236 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N,M;//써야할 돈의 리스트,인출할 횟수
    static int[] moneys;//써야할 돈의 리스트
    static int start,end;//인출할 돈의 최소,최대량
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();
        
        moneys=new int[N];
        for(int i=0;i<N;i++){
            moneys[i]=fr.nextInt();
            //start은 하루에 필요한 최대 금액이다
            start=Math.max(start,moneys[i]);
            //end는 요구한 돈의 총량이다
            end+=moneys[i];
        }
    }

    static void process(){
        //필요한 금액을 변수로 M번 인출가능한지 이분 탐색
        int result=binarySearch(start, end, M);
        System.out.println(result);
    }
    /**
     * M번 인출할때 한번에 인출할 최소금액을 구하는 메소드
     * @param start 최소 금액
     * @param end 최대 금액
     * @param result 인출 횟수
     * @return 한번에 인출할 최소 금액
     */
    static int binarySearch(int start,int end,int result){
        int money=start;//못구하면 최소 금액을 인출해야한다.
        while(start <= end){
            int mid=(start+end)/2;
            //해당 금액이 인출 가능하면 금액을 줄이자.
            if(canWithdraw(mid,result)){
                money=mid;
                end=mid-1;
            }
            //불가능하면 금액을 늘리자
            else{
                start=mid+1;
            }
        }
        return money;
    }
    /**
     * money를 count만큼 인출해서 지낼수 있냐?
     * @param money 한번에 인출할 금액
     * @param count 인출 횟수
     * @return
     */
    static boolean canWithdraw(int money,int count){
        //처음에 돈을 뺀다
        count--;
        int sum=money;
        for(int i=0;i<N;i++){
            //현재 돈으로 해결가능하냐?
            if(sum >= moneys[i]){
                sum-=moneys[i];
            }
            //현재 돈으로 불가능하냐?
            else{
                //돈을 재인출
                count--;
                sum=money;
                sum-=moneys[i];
            }
        }
        //인출 횟수가 부족해서 불가능
        if(count < 0)
            return false;
        else
            return true;
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

